package com.pass.cloud.uac.model.vo;

import java.io.Serializable;

import com.pass.cloud.base.dto.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleVo extends BaseVo implements Serializable {

    private static final long serialVersionUID = 3819529748816533170L;

    /**
     * 角色编码
     */
    private String roleCode;

    private String roleName;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

}
