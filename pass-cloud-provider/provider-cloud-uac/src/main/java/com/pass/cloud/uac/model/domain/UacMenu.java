package com.pass.cloud.uac.model.domain;

import javax.persistence.Column;
import javax.persistence.Table;

import com.pass.cloud.core.mybatis.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * @author takesi
 */
@Data
@Alias("uacMenu")
@Table(name = "pc_uac_menu")
@EqualsAndHashCode(callSuper = true)
public class UacMenu extends BaseEntity {

    private static final long serialVersionUID = 454644589405700059L;

    /**
     * 菜单编码
     */
    @Column(name = "menu_code")
    private String menuCode;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 状态
     */
    private String status;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 图标
     */
    private String icon;

    /**
     * 父ID
     */
    private Long pid;

    /**
     * 层级(最多三级1,2,3)
     */
    private Integer level;

    /**
     * 是否叶子节点,1不是0是
     */
    private Integer leaf;

    /**
     * 序号
     */
    private Integer number;

    /**
     * 备注
     */
    private String remark;
    /**
     * 系统ID
     */
    @Column(name = "application_id")
    private Long applicationId;

}
