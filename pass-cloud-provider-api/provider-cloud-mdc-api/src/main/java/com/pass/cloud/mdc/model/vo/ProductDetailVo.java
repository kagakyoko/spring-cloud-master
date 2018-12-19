package com.pass.cloud.mdc.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class ProductDetailVo implements Serializable {

    private static final long serialVersionUID = 4852861985938951261L;

    private Long id;

    private String name;

    private String subtitle;

    private String mainImage;

    private String subImages;

    private String detail;

    private BigDecimal price;

    private Integer stock;

    private Integer status;

    private String imageHost;

    private Long pid;

}
