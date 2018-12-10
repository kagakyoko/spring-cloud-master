package com.pass.cloud.uac.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author takesi
 */
@Data
@Alias(value = "uacGroupUser")
@Table(name = "pc_uac_group_user")
public class UacGroupUser implements Serializable {

    private static final long serialVersionUID = 5167709959453148144L;

    /**
     * 角色ID
     */
    @Column(name = "group_id")
    private Long groupId;

    /**
     * 菜单ID
     */
    @Column(name = "user_id")
    private Long userId;

}
