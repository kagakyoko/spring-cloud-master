package com.pass.cloud.uac.model.dto.user;

import java.io.Serializable;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class ResetLoginPwdDto implements Serializable {

    private static final long serialVersionUID = -3599630825681985964L;

    /**
     * 新密码
     */
    private String resetPwdKey;

    /**
     * 新密码
     */
    private String newPassword;

    /**
     * 确认密码
     */
    private String confirmPwd;

}
