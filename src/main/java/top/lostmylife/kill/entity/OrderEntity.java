package top.lostmylife.kill.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import top.lostmylife.kill.common.entity.BaseEntity;

/**
 * @author zl
 * @date 2020/3/25
 * @copyright www.lostmylife.top Inc. All rights reserved.
 * @since
 */
@Setter
@Getter
@TableName("tb_order")
public class OrderEntity extends BaseEntity {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * skuId
     */
    private Long skuId;

}
