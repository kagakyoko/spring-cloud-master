package com.pass.cloud.uac.model.dto.user;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户忘记密码Dto
 *
 * @author takesi
 */
@Data
public class UserResetPwdDto implements Serializable {

    private static final long serialVersionUID = 1036552024852502298L;

    /**
     * 手机号
     */
    private String mobileNo;

    /**
     * 新密码
     */
    private String newPassword;

    /**
     * 确认密码
     */
    private String confirmPwd;

    /**
     * 短信验证码
     */
    private String smsCode;

}
