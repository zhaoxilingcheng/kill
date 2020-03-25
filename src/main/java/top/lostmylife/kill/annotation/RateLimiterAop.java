package top.lostmylife.kill.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author zl
 * @date 2020/3/25
 * @copyright www.lostmylife.top Inc. All rights reserved.
 * @since
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiterAop {

    /**
     * 桶容量 默认为1
     *
     * @return
     */
    long capacity() default 1;

    /**
     * 间隔时间 按时间单位换算
     *
     * @return
     */
    long intervalTime() default 1000;

    /**
     * 时间单位 默认为毫秒
     *
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;

    /**
     * springEl表达式
     * key为空时 method.getName
     *
     * @return
     */
    String key() default "";

    /**
     * 异常i18n编码定义
     *
     * @return
     */
    @AliasFor("errorCode")
    String value();

    /**
     * 定义作用域
     * 为空时取class.getName
     *
     * @return
     */
    String scopeName() default "";

}


