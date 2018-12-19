package com.pass.cloud.mdc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class ProductDto implements Serializable {

    private static final long serialVersionUID = 6932649538854879183L;

    /**
     * 货品ID
     */
    private Long id;

    /**
     * 分类ID
     */
    private Long categoryId;

    private String name;

    /**
     * 子标题
     */
    private String subtitle;

    /**
     * 首图
     */
    private String mainImage;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 图片服务器前缀
     */
    private String imageHost;

    /**
     * 库存数量
     */
    private Integer stock;

    /**
     * 商品序列号
     */
    private String productCode;

    /**
     * 变化的库存数量
     */
    private Integer changeStock;

}
