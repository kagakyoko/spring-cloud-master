package com.pass.cloud.uac.model.dto.user;

import java.io.Serializable;

import lombok.Data;

/**
 * 重置密码.
 *
 * @author takesi
 */
@Data
public class ResetPasswordDto implements Serializable {

    private static final long serialVersionUID = 4762153981220090958L;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 旧密码
     */
    private String passwordOld;

    /**
     * 新密码
     */
    private String passwordNew;

}
