package top.lostmylife.kill.common;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static top.lostmylife.kill.common.KillBusinessCode.ERROR_CODE;

// 暂时放在这个实体，当多个模块时抽出来

/**
 * @author zl
 * @date 2020/3/25
 * @copyright www.lostmylife.top Inc. All rights reserved.
 * @since
 */
public class RateLimiterCode {

    private final static List<IBusinessCode> LIST = new LinkedList<>();

    static {
        LIST.add(KillBusinessCode.INVENTORY_SHORTAGE);
    }

    public static IBusinessCode getByErrorCode(String errorCode) {
        Optional<IBusinessCode> first = LIST.stream().filter(i -> i.getErrorCode().equals(errorCode)).findFirst();
        return first.orElse(ERROR_CODE);
    }

}
