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
@TableName("tb_sku")
public class SkuEntity extends BaseEntity {

    /**
     * 商品名称
     */
    private String name;

    /**
     * 剩余库存
     */
    private Long stock;

    /**
     * 冻结库存
     */
    private Long frozenStock;

    /**
     * 总库存
     */
    private Long totalStock;

    /**
     * 已售
     */
    private Long sold;

}
