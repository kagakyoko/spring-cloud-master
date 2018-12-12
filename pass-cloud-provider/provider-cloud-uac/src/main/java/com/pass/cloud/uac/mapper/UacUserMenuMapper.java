package com.pass.cloud.uac.mapper;

import com.pass.cloud.core.mybatis.MyMapper;
import com.pass.cloud.uac.model.domain.UacUserMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author takesi
 */
@Mapper
@Repository
public interface UacUserMenuMapper extends MyMapper<UacUserMenu> {

}
