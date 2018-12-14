package com.pass.cloud.uac.model.vo;

import com.pass.cloud.base.dto.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "资源路径")
    private String url;

    /**
     * 权限名称
     */
    @ApiModelProperty(value = "权限名称")
    private String actionName;

    /**
     * 权限
     */
    @ApiModelProperty(value = "权限")
    private String actionCode;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String status;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 菜单ID
     */
    @ApiModelProperty(value = "菜单ID")
    private Long menuId;

    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "菜单名称")
    private String menuName;

}
