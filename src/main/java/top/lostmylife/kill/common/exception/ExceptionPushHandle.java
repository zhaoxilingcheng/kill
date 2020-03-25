package top.lostmylife.kill.common.exception;

import top.lostmylife.kill.common.code.IBusinessCode;

/**
 * @author zl
 * @date 2020/3/25
 * @copyright www.lostmylife.top Inc. All rights reserved.
 * @since
 */
public class ExceptionPushHandle {

    public static void pushException(IBusinessCode iBusinessCode) {
        throw new BaseException(iBusinessCode.getBusinessCode(), iBusinessCode.getErrorMessage());
    }

}
