package com.pass.cloud.uac.model.dto.group;

import java.io.Serializable;
import java.util.Set;

import com.pass.cloud.uac.model.dto.role.BindUserDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@ApiModel(value = "GroupBindUserDto")
public class GroupBindUserDto implements Serializable {

    private static final long serialVersionUID = 1383005712348886707L;
    /**
     * 未绑定的用户集合
     */
    @ApiModelProperty(value = "所有用户集合")
    private Set<BindUserDto> allUserSet;

    /**
     * 已经绑定的用户集合
     */
    @ApiModelProperty(value = "已经绑定的用户集合")
    private Set<Long> alreadyBindUserIdSet;

}
