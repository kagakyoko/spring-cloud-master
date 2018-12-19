package com.pass.cloud.uac.model.dto.user;

import java.io.Serializable;

import lombok.Data;

/**
 * 忘记密码.
 *
 * @author takesi
 */
@Data
public class ForgetResetPasswordDto implements Serializable {

    private static final long serialVersionUID = 5478700873789068921L;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 密码
     */
    private String loginPwd;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 验证码
     */
    private String emailCode;

    /**
     * token
     */
    private String forgetToken;

}
