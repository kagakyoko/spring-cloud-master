package com.pass.cloud.uac.model.dto.user;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author
 */
@Data
@ApiModel
public class BindUserRolesDto implements Serializable {

    private static final long serialVersionUID = -9149237379943908522L;

    @ApiModelProperty(value = "角色ID")
    private Long userId;

    @ApiModelProperty(value = "需要绑定的角色ID集合")
    private List<Long> roleIdList;

}
