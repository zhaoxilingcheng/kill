package top.lostmylife.kill.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import top.lostmylife.kill.common.entity.BaseEntity;
import top.lostmylife.kill.common.enums.SecKillStatus;

import java.util.Date;

/**
 * @author zl
 * @date 2020/3/25
 * @copyright www.lostmylife.top Inc. All rights reserved.
 * @since
 */
@Setter
@Getter
@TableName("tb_sec_kill")
public class SecKillEntity extends BaseEntity {

    private Long skuId;

    /**
     * 初始化库存
     */
    private Long stock;

    /**
     * 已售库存
     */
    private Long sold;

    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 结束时间
     */
    private Date endDate;

    /**
     * 状态
     * @see SecKillStatus
     */
    private SecKillStatus status;

}
