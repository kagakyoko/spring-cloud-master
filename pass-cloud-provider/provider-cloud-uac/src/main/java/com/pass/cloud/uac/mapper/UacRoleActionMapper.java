package com.pass.cloud.uac.mapper;

import java.util.List;

import com.pass.cloud.core.mybatis.MyMapper;
import com.pass.cloud.uac.model.domain.UacRoleAction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author takesi
 */
@Mapper
@Repository
public interface UacRoleActionMapper extends MyMapper<UacRoleAction> {

    /**
     * Delete by action id int.
     *
     * @param actionId the action id
     * @return the int
     */
    int deleteByActionId(@Param("actionId") Long actionId);

    /**
     * Delete by role id list int.
     *
     * @param roleIdList the role id list
     * @return the int
     */
    int deleteByRoleIdList(@Param("roleIdList") List<Long> roleIdList);

}
