package top.lostmylife.kill.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import top.lostmylife.kill.common.BaseException;
import top.lostmylife.kill.common.Result;

/**
 * @author zl
 * @date 2020/3/25
 * @copyright www.lostmylife.top Inc. All rights reserved.
 * @since
 */
@Slf4j
@RestControllerAdvice
public class KillExceptionHandler {

    /**
     * 处理业务抛出异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public Result<?> handleRRException(BaseException e) {
        return e.buildResult();
    }

    /**
     * 处理404异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result<?> handlerNoFoundException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.ok();
    }

    /**
     * 系统异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error();
    }

}
