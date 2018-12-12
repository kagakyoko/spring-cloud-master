package com.pass.cloud.uac.model.dto.user;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@ApiModel
public class ResetLoginPwdDto implements Serializable {

    private static final long serialVersionUID = -3599630825681985964L;
    /**
     * 新密码
     */
    @ApiModelProperty(value = "密钥")
    private String resetPwdKey;
    /**
     * 新密码
     */
    @ApiModelProperty(value = "新密码")
    private String newPassword;

    /**
     * 确认密码
     */
    @ApiModelProperty(value = "确认密码")
    private String confirmPwd;

}
