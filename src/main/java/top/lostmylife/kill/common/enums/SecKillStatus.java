package top.lostmylife.kill.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zl
 * @date 2020/3/25
 * @copyright www.lostmylife.top Inc. All rights reserved.
 * @since
 */
@Getter
@AllArgsConstructor
public enum SecKillStatus {
    INIT(1, "初始化"),
    RUN_ING(2, "运行中"),
    END_ING(3, "结束");

    @EnumValue
    private int value;

    private String desc;

}
