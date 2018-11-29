package com.pass.cloud.mdc.model.dto;

import com.pass.cloud.base.dto.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 */
@Data
@ApiModel
@EqualsAndHashCode(callSuper = true)
public class ProductReqDto extends BaseQuery {

    private static final long serialVersionUID = -9070173642901418263L;

    @ApiModelProperty(value = "分类ID")
    private Long categoryId;

    @ApiModelProperty(value = "关键词")
    private String keyword;

}
