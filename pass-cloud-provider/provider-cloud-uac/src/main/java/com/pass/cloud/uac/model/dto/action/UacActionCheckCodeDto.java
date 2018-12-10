package com.pass.cloud.uac.model.dto.action;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@ApiModel(value = "UacActionCheckCodeDto")
public class UacActionCheckCodeDto implements Serializable {

    private static final long serialVersionUID = 8687848883145768024L;
    /**
     * 权限的id
     */
    @ApiModelProperty(value = "权限的id")
    private Long actionId;

    /**
     * 权限的url
     */
    @ApiModelProperty(value = "权限编码")
    @NotBlank(message = "权限编码不能为空")
    private String actionCode;

}
