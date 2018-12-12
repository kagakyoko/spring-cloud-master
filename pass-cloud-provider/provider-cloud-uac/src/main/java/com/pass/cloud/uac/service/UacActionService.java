package com.pass.cloud.uac.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pass.cloud.core.support.IService;
import com.pass.cloud.uac.model.domain.UacAction;
import com.pass.cloud.uac.model.domain.UacMenu;
import com.pass.cloud.uac.model.dto.action.ActionMainQueryDto;
import com.pass.cloud.uac.model.vo.ActionVo;
import com.pass.cloud.uac.model.vo.MenuVo;

/**
 * @author takesi
 */
public interface UacActionService extends IService<UacAction> {

    /**
     * Query action list with page page info.
     *
     * @param actionMainQueryDto the action main query dto
     * @return the page info
     */
    PageInfo<ActionVo> queryActionListWithPage(ActionMainQueryDto actionMainQueryDto);

    /**
     * Delete action by id int.
     *
     * @param actionId the action id
     * @return the int
     */
    int deleteActionById(Long actionId);

    /**
     * Batch delete by id list.
     *
     * @param deleteIdList the delete id list
     */
    void batchDeleteByIdList(List<Long> deleteIdList);

    /**
     * Delete by menu id int.
     *
     * @param id the id
     * @return the int
     */
    int deleteByMenuId(Long id);

    /**
     * Gets checked auth list.
     *
     * @param roleId the role id
     * @return the checked auth list
     */
    List<Long> getCheckedActionList(Long roleId);

    /**
     * Gets own auth list.
     *
     * @param userId the user id
     * @return the own auth list
     */
    List<MenuVo> getOwnAuthList(Long userId);

    /**
     * Gets checked menu list.
     *
     * @param roleId the role id
     * @return the checked menu list
     */
    List<Long> getCheckedMenuList(Long roleId);

    /**
     * 根据用户Id查询拥有的按钮权限.
     *
     * @param userId the user id
     * @return the own uac action list
     */
    List<UacAction> getOwnActionListByUserId(Long userId);

    /**
     * 根据角色ID查询权限列表.
     *
     * @param roleId the role id
     * @return the list
     */
    List<UacAction> listActionListByRoleId(Long roleId);

    /**
     * 根据菜单ID List 查询权限列表.
     *
     * @param uacMenus the uac menus
     * @return the list
     */
    List<UacAction> listActionList(List<UacMenu> uacMenus);

    /**
     * Matches by url uac action.
     *
     * @param requestUrl the request url
     * @return the uac action
     */
    UacAction matchesByUrl(String requestUrl);

}
