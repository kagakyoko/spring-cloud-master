package com.pass.cloud.uac.model.dto.action;

import java.util.List;

import com.pass.cloud.base.dto.BaseQuery;

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
public class ActionMainQueryDto extends BaseQuery {

    private static final long serialVersionUID = -1755881173841393763L;
    /**
     * 资源路径
     */
    @ApiModelProperty(name = "资源路径")
    private String url;

    /**
     * 权限名称
     */
    @ApiModelProperty(name = "权限名称")
    private String actionName;

    /**
     * 权限编码
     */
    @ApiModelProperty(name = "权限编码")
    private String actionCode;

    /**
     * 状态
     */
    @ApiModelProperty(name = "状态")
    private String status;

    /**
     * 菜单ID
     */
    @ApiModelProperty(name = "菜单ID")
    private List<Long> menuIdList;

}
