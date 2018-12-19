package com.pass.cloud.uac.model.dto.user;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户修改密码Dto
 *
 * @author takesi
 */
@Data
public class UserModifyPwdDto implements Serializable {

    private static final long serialVersionUID = -3933378415083541145L;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 原始密码
     */
    private String oldPassword;

    /**
     * 新密码
     */
    private String newPassword;

    /**
     * 确认密码
     */
    private String confirmPwd;

}
