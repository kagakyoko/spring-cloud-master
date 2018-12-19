package com.pass.cloud.uac.model.dto.user;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户注册Dto
 *
 * @author takesi
 */
@Data
public class UserRegisterDto implements Serializable {

    private static final long serialVersionUID = -8019925037057525804L;

    /**
     * 用户名
     */
    private String loginName;

    /**
     * 手机号
     */
    private String mobileNo;

    /**
     * 密码
     */
    private String loginPwd;

    /**
     * 确认密码
     */
    private String confirmPwd;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 注册token
     */
    private String registerSource;

}
