package com.pass.cloud.uac.model.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@ApiModel
public class BindAuthVo {

    /**
     * 包含按钮权限和菜单权限
     */
    private List<MenuVo> authTree;

    /**
     * 该角色含有的权限ID
     */
    private List<Long> checkedAuthList;

}
