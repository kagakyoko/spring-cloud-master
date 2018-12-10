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
@Alias("uacRoleMenu")
@Table(name = "pc_uac_role_menu")
public class UacRoleMenu implements Serializable {

    private static final long serialVersionUID = -9052683954152822756L;

    @Id
    @Column(name = "role_id")
    private Long roleId;

    @Id
    @Column(name = "menu_id")
    private Long menuId;

}
