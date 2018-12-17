package com.pass.cloud.mdc.model.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class ProductCategoryDto implements Serializable {

    private static final long serialVersionUID = -5217129132596232253L;

    /**
     * 类别ID
     */
    private Long categoryId;

    /**
     * 类别名称
     */
    private String categoryName;

    /**
     * 首图URL
     */
    private String imgUrl;

    private List<ProductCategoryDto> categoryList;

}
