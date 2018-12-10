package com.pass.cloud.uac.model.vo;

import java.io.Serializable;
import java.util.Set;

import com.pass.cloud.uac.model.dto.user.BindRoleDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@ApiModel(value = "角色绑定用户")
public class UserBindRoleVo implements Serializable {

    private static final long serialVersionUID = -2521583668470612548L;
    /**
     * 未绑定的用户集合
     */
    @ApiModelProperty(value = "所有用户集合")
    private Set<BindRoleDto> allRoleSet;

    /**
     * 已经绑定的用户集合
     */
    @ApiModelProperty(value = "已经绑定的用户集合")
    private Set<Long> alreadyBindRoleIdSet;

}
