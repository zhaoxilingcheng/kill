package top.lostmylife.kill.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import top.lostmylife.kill.annotation.RateLimiterAop;
import top.lostmylife.kill.common.exception.ExceptionPushHandle;
import top.lostmylife.kill.common.code.IBusinessCode;
import top.lostmylife.kill.common.code.RateLimiterCode;
import top.lostmylife.kill.utils.RedisLimitUtils;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @author zl
 * @date 2020/3/25
 * @copyright www.lostmylife.top Inc. All rights reserved.
 * @since
 */
@Slf4j
@Aspect
@Component
public class RedisRateLimiterAspect {

    private ExpressionParser parser = new SpelExpressionParser();

    @Autowired
    private RedisLimitUtils redisLimitUtils;

    @Pointcut("@annotation(top.lostmylife.kill.annotation.RateLimiterAop)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        String className = point.getTarget().getClass().getName();
        Object[] args = point.getArgs();
        String[] paramNames = signature.getParameterNames();
        EvaluationContext context = new StandardEvaluationContext();
        for (int i = 0; i < args.length; i++) {
            context.setVariable(paramNames[i], args[i]);
        }
        RateLimiterAop limiterAop = method.getAnnotation(RateLimiterAop.class);
        TimeUnit timeUnit = limiterAop.timeUnit();
        //桶容量
        long capacity = limiterAop.capacity();
        //间隔时间(速率) 毫秒
        long intervalTime = timeUnit.toMillis(limiterAop.intervalTime());
        //业务i18n异常编码
        String errorCode = limiterAop.value();
        IBusinessCode byErrorCode = RateLimiterCode.getByErrorCode(errorCode);
        //key为空时锁方法，否则按SpringEl表达式取值
        String key = StringUtils.isEmpty(limiterAop.key()) ? method.getName() : parser.parseExpression(limiterAop.key()).getValue
                (context, String.class);
        //作用域为空时取className
        String limiterAopName = StringUtils.isEmpty(limiterAop.scopeName()) ? className : limiterAop.scopeName();
        //构造redisKey
        String redisKey = limiterAopName + "#" + key;
        //设置过期时间为间隔时间*容量*5
        if (redisLimitUtils.limitHandler(redisKey, capacity, intervalTime, intervalTime * capacity * 5L)) {
            log.info("获取令牌成功!class={},method={},key={}", className, method, redisKey);
            //执行方法
            return point.proceed();
        }
        log.info("获取令牌失败,class={},method={},key={}", className, method, redisKey);
        ExceptionPushHandle.pushException(byErrorCode);
        //失败处理逻辑
        return null;
    }

}

