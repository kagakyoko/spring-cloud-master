package com.pass.cloud.uac.model.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 菜单
 *
 * @author takesi
 */
@Data
public class MenuVo implements Serializable {

    /**
     * serialVersionUID:用一句话描述这个变量表示什么.
     *
     * @since JDK 1.7
     */
    private static final long serialVersionUID = -2099147126084213856L;

    /**
     * menu.id
     * 菜单编号
     */
    private Long id;

    /**
     * 父id
     */
    private Long pid;

    /**
     * 菜单编码
     */
    private String menuCode;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单URL
     */
    private String url;
    /**
     * 图标
     */
    private String icon;

    /**
     * 序号
     */
    private String number;

    /**
     * 备注(研发中心)
     */
    private String remark;

    /**
     * 删除标识
     */
    private Short yn;

    private MenuVo parentMenu;

    private List<MenuVo> subMenu;

    private boolean hasMenu = false;

}
