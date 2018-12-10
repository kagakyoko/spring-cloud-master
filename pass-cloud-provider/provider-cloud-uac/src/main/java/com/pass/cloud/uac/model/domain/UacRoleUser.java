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
@Alias("uacRoleUser")
@Table(name = "pc_uac_role_user")
public class UacRoleUser implements Serializable {

    private static final long serialVersionUID = -4598936929315554832L;

    @Id
    @Column(name = "role_id")
    private Long roleId;

    @Id
    @Column(name = "user_id")
    private Long userId;

}
