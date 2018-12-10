package com.pass.cloud.uac.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.pass.cloud.core.mybatis.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

/**
 * @author takesi
 */
@Data
@Alias("uacRole")
@Table(name = "pc_uac_role")
@EqualsAndHashCode(callSuper = true)
public class UacRole extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -6049575043793281879L;

    /**
     * 角色编码
     */
    @Column(name = "role_code")
    @Length(min = 6, max = 20, message = "{role.roleCode.length}")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "{role.roleCode.pattern}")
    private String roleCode;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    @Length(min = 4, max = 10, message = "{role.roleName.length}")
    @Pattern(regexp = "^[\\u4e00-\\u9faf]+$", message = "{role.roleName.pattern}")
    private String roleName;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    @Length(max = 150, message = "{role.remark.length}")
    private String remark;

}
