package com.pass.cloud.uac.service;

import java.util.List;

import com.pass.cloud.core.support.IService;
import com.pass.cloud.uac.model.domain.UacGroup;
import com.pass.cloud.uac.model.dto.group.GroupBindUserDto;
import com.pass.cloud.uac.model.vo.GroupZtreeVo;
import com.pass.cloud.uac.model.vo.MenuVo;

/**
 * @author takesi
 */
public interface UacGroupService extends IService<UacGroup> {

    /**
     * Delete uac group by id int.
     *
     * @param id the id
     * @return the int
     */
    int deleteUacGroupById(Long id);

    /**
     * Query by id uac group.
     *
     * @param groupId the group id
     * @return the uac group
     */
    UacGroup queryById(Long groupId);

    /**
     * Gets group tree.
     *
     * @param id the id
     * @return the group tree
     */
    List<GroupZtreeVo> getGroupTree(Long id);

    /**
     * Find current user have group info list.
     *
     * @param userId the user id
     * @return the list
     */
    List<MenuVo> getGroupTreeListByUserId(Long userId);

    /**
     * Gets group bind user dto.
     *
     * @param groupId the group id
     * @param userId  the user id
     * @return the group bind user dto
     */
    GroupBindUserDto getGroupBindUserDto(Long groupId, Long userId);

}
