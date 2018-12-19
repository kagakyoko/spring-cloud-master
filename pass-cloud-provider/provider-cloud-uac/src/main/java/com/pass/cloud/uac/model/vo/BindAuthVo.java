package com.pass.cloud.uac.model.vo;

import java.util.List;

import lombok.Data;

/**
 * @author takesi
 */
@Data
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
