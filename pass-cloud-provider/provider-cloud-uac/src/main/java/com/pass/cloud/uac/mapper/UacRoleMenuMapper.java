package com.pass.cloud.uac.mapper;

import java.util.List;

import com.pass.cloud.core.mybatis.MyMapper;
import com.pass.cloud.uac.model.domain.UacRoleMenu;
import com.pass.cloud.uac.model.vo.role.MenuCountVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author takesi
 */
@Mapper
@Repository
public interface UacRoleMenuMapper extends MyMapper<UacRoleMenu> {

    /**
     * Count child menu num list.
     *
     * @param roleId the role id
     * @return the list
     */
    List<MenuCountVo> countChildMenuNum(Long roleId);

    /**
     * Add role menu list int.
     *
     * @param addUacRoleMenuList the add uac role menu list
     * @return the int
     */
    int addRoleMenuList(List<UacRoleMenu> addUacRoleMenuList);

    /**
     * Delete by role id list int.
     *
     * @param roleIdList the role id list
     * @return the int
     */
    int deleteByRoleIdList(@Param("roleIdList") List<Long> roleIdList);

}
