package com.pass.cloud.uac.model.domain;

import com.pass.cloud.core.mybatis.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UacUserMenu extends BaseEntity {

    private static final long serialVersionUID = 71826276587527887L;
    /**
     * pc_uac_user_menu.user_id;用户id
     */
    private Long userId;

    /**
     * pc_uac_user_menu.menu_id;菜单id
     */
    private Long menuId;

    /**
     * pc_uac_user_menu.number;序号
     */
    private Integer number;

}
