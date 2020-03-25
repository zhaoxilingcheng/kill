package top.lostmylife.kill.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zl
 * @date 2020/3/25
 * @copyright www.lostmylife.top Inc. All rights reserved.
 * @since
 */
@Getter
@Setter
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -6446521860830766808L;

    // 业务编码
    private String code;

    // 业务描述
    private String msg;

    //有参的构造方法
    public BaseException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    //用指定原因构造一个新的异常
    public BaseException(String code, String msg, Throwable cause) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }

    public Result<?> buildResult() {
        return new Result<>(code, msg);
    }

}