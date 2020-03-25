package top.lostmylife.kill.common;

/**
 * @author zl
 * @date 2020/3/25
 * @copyright www.lostmylife.top Inc. All rights reserved.
 * @since
 */
public enum KillBusinessCode implements IBusinessCode {

    ERROR_PARAM("10001", "参数错误"),
    ERROR_CODE("10002", "Code不存在"),
    INVENTORY_SHORTAGE("10003", "库存不足");


    private static final String HEARD = "kill-";

    private String errorCode;

    private String errorMessage;

    KillBusinessCode(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String getBusinessHeard() {
        return HEARD;
    }

}
