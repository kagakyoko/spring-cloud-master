package com.pass.cloud.uac.mapper;

import java.util.List;

import com.pass.cloud.core.mybatis.MyMapper;
import com.pass.cloud.uac.model.domain.UacGroup;
import com.pass.cloud.uac.model.domain.UacGroupUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author takesi
 */
@Mapper
@Repository
public interface UacGroupUserMapper extends MyMapper<UacGroupUser> {

    /**
     * Query by user id uac group user.
     *
     * @param userId the user id
     * @return the uac group user
     */
    UacGroupUser getByUserId(Long userId);

    /**
     * Update by user id int.
     *
     * @param uacGroupUser the uac group user
     * @return the int
     */
    int updateByUserId(UacGroupUser uacGroupUser);

    /**
     * Select group list by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    List<UacGroup> selectGroupListByUserId(Long userId);

    /**
     * List by group id list.
     *
     * @param groupId the group id
     * @return the list
     */
    List<UacGroupUser> listByGroupId(@Param("groupId") Long groupId);

    /**
     * Delete exclude super mng int.
     *
     * @param groupId            the group id
     * @param superManagerRoleId the super manager role id
     * @return the int
     */
    int deleteExcludeSuperMng(@Param("currentGroupId") Long groupId, @Param("superManagerRoleId") Long superManagerRoleId);

}
