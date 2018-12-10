package com.pass.cloud.uac.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author takesi
 */
@Data
@Alias("uacRoleAction")
@Table(name = "pc_uac_role_action")
public class UacRoleAction implements Serializable {

    private static final long serialVersionUID = -4240611881810188284L;

    @Id
    @Column(name = "role_id")
    private Long roleId;

    @Id
    @Column(name = "action_id")
    private Long actionId;

}
