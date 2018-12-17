package com.pass.cloud.uac.model.dto.user;

import java.io.Serializable;

import lombok.Data;

/**
 * 登录参数
 * @author takesi
 */
@Data
public class LoginReqDto implements Serializable {

    private static final long serialVersionUID = -3455057005375331843L;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 密码
     */
    private String loginPwd;

    /**
     * 登录IP地址
     */
    private String ip;

    /**
     * 登录秘钥
     */
    private String secToken;

    /**
     * 系统ID
     */
    private Long applicationId;

}
