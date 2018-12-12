package com.pass.cloud.uac.mapper;

import java.util.List;

import com.pass.cloud.core.mybatis.MyMapper;
import com.pass.cloud.uac.model.domain.UacRole;
import com.pass.cloud.uac.model.dto.role.BindUserDto;
import com.pass.cloud.uac.model.vo.RoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author takesi
 */
@Mapper
@Repository
public interface UacRoleMapper extends MyMapper<UacRole> {

    /**
     * Find by role code uac role.
     *
     * @param roleCode the role code
     * @return the uac role
     */
    UacRole findByRoleCode(String roleCode);

    /**
     * Query role list with page list.
     *
     * @param role the role
     * @return the list
     */
    List<RoleVo> queryRoleListWithPage(UacRole role);

    /**
     * Select all role info by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    List<UacRole> selectAllRoleInfoByUserId(Long userId);

    /**
     * Select role list list.
     *
     * @param uacRole the uac role
     * @return the list
     */
    List<UacRole> selectRoleList(UacRole uacRole);

    /**
     * Batch delete by id list int.
     *
     * @param idList the id list
     * @return the int
     */
    int batchDeleteByIdList(@Param("idList") List<Long> idList);

    /**
     * Select all need bind user list.
     *
     * @param superManagerRoleId the super manager role id
     * @param currentUserId      the current user id
     * @return the list
     */
    List<BindUserDto> selectAllNeedBindUser(@Param("superManagerRoleId") Long superManagerRoleId, @Param("currentUserId") Long currentUserId);

}