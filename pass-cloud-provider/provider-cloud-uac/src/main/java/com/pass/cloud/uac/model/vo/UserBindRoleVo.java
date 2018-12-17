package com.pass.cloud.uac.model.vo;

import java.io.Serializable;
import java.util.Set;

import com.pass.cloud.uac.model.dto.user.BindRoleDto;
import lombok.Data;

/**
 * 角色绑定用户
 *
 * @author takesi
 */
@Data
public class UserBindRoleVo implements Serializable {

    private static final long serialVersionUID = -2521583668470612548L;

    /**
     * 未绑定的用户集合
     */
    private Set<BindRoleDto> allRoleSet;

    /**
     * 已经绑定的用户集合
     */
    private Set<Long> alreadyBindRoleIdSet;

}
