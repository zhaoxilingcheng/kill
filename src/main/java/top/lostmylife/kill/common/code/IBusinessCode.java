package top.lostmylife.kill.common.code;

/**
 * @author zl
 * @date 2020/3/25
 * @copyright www.lostmylife.top Inc. All rights reserved.
 * @since
 */
public interface IBusinessCode {

    String getErrorCode();

    String getErrorMessage();

    /**
     * 用于区分属于哪一个模块发生的异常
     *
     * @return
     */
    String getBusinessHeard();

    default String getBusinessCode() {
        return getErrorCode() + getBusinessHeard();
    }

}
