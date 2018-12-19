package com.pass.cloud.uac.model.dto.user;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @author
 */
@Data
public class BindUserRolesDto implements Serializable {

    private static final long serialVersionUID = -9149237379943908522L;

    /**
     * 角色ID
     */
    private Long userId;

    /**
     * 需要绑定的角色ID集合
     */
    private List<Long> roleIdList;

}
