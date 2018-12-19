package com.pass.cloud.mdc.model.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Table;

import com.pass.cloud.core.mybatis.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * @author takesi
 */
@Data
@Alias("mdcProduct")
@Table(name = "pc_mdc_product")
@EqualsAndHashCode(callSuper = true)
public class MdcProduct extends BaseEntity {

    private static final long serialVersionUID = 2051481072581512778L;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品编码
     */
    @Column(name = "product_code")
    private String productCode;

    @Column(name = "category_id")
    private Long categoryId;

    /**
     * 商品副标题
     */
    private String subtitle;

    /**
     * 产品主图,url相对地址
     */
    @Column(name = "main_image")
    private String mainImage;

    /**
     * 价格,单位-元保留两位小数
     */
    private BigDecimal price;

    /**
     * 库存数量
     */
    private Integer stock;

    /**
     * 商品状态.1-在售 2-下架 3-删除
     */
    private Integer status;

    /**
     * 图片地址,json格式,扩展用
     */
    @Column(name = "sub_images")
    private String subImages;

    /**
     * 商品详情
     */
    private String detail;

}
