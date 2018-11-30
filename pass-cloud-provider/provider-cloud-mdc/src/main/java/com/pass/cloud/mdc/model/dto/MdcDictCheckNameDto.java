package com.pass.cloud.mdc.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@ApiModel
public class MdcDictCheckNameDto implements Serializable {

    private static final long serialVersionUID = 8687848883145768024L;
    /**
     * 菜单的id
     */
    @ApiModelProperty(value = "数据字典id")
    private Long dictId;
    /**
     * 菜单的url
     */
    @ApiModelProperty(value = "数据字典名称")
    @NotBlank(message = "数据字典名称不能为空")
    private String dictName;

}