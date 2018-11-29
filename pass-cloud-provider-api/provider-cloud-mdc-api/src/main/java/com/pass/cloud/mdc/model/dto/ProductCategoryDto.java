package com.pass.cloud.mdc.model.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@ApiModel
public class ProductCategoryDto implements Serializable {

    private static final long serialVersionUID = -5217129132596232253L;

    @ApiModelProperty(value = "类别ID")
    private Long categoryId;

    @ApiModelProperty(value = "类别名称")
    private String categoryName;

    @ApiModelProperty(value = "首图URL")
    private String imgUrl;

    private List<ProductCategoryDto> categoryList;

}
