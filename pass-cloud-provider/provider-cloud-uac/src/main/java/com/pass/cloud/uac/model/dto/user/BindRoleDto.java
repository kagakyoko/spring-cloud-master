package com.pass.cloud.uac.model.dto.user;

import java.io.Serializable;

import lombok.Data;

/**
 * 绑定的用户信息
 *
 * @author takesi
 */
@Data
public class BindRoleDto implements Serializable {

    private static final long serialVersionUID = -3385971785265488527L;

    /**
     * 用户ID
     */
    private Long roleId;

    /**
     * 手机号
     */
    private String roleCode;

    /**
     * 用户名
     */
    private String roleName;

    /**
     * 是否可以操作
     */
    private boolean disabled;

}
