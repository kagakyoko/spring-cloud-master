package com.pass.cloud.base.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * 登录人信息
 * @author takesi
 */
@Data
public class LoginAuthDto implements Serializable {

    private static final long serialVersionUID = -1137852221455042256L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 组织ID
     */
    private Long groupId;

    /**
     * 组织名称
     */
    private String groupName;

    public LoginAuthDto() {
    }

    public LoginAuthDto(Long userId, String loginName, String userName) {
        this.userId = userId;
        this.loginName = loginName;
        this.userName = userName;
    }

    public LoginAuthDto(Long userId, String loginName, String userName, Long groupId, String groupName) {
        this.userId = userId;
        this.loginName = loginName;
        this.userName = userName;
        this.groupId = groupId;
        this.groupName = groupName;
    }

}
