package com.pass.cloud.uac.model.vo;

import com.pass.cloud.base.dto.BaseVo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 */
@Data
@ApiModel
@EqualsAndHashCode(callSuper = true)
public class ActionVo extends BaseVo {

    private static final long serialVersionUID = 2019306004446193459L;
    /**
     * 资源路径
     */
    private String url;

    /**
     * 权限名称
     */
    private String actionName;

    /**
     * 权限
     */
    private String actionCode;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 菜单名称
     */
    private String menuName;

}
