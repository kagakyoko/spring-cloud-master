package com.pass.cloud.uac.model.dto.user;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 重置密码.
 *
 * @author takesi
 */
@Data
@ApiModel
public class ResetPasswordDto implements Serializable {

    private static final long serialVersionUID = 4762153981220090958L;

    @ApiModelProperty("登录名")
    private String loginName;

    @ApiModelProperty(value = "旧密码")
    private String passwordOld;

    @ApiModelProperty(value = "新密码")
    private String passwordNew;

}
