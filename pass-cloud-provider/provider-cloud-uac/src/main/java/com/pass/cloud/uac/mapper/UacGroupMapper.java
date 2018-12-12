package com.pass.cloud.uac.mapper;

import com.pass.cloud.core.mybatis.MyMapper;
import com.pass.cloud.uac.model.domain.UacGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author takesi
 */
@Mapper
@Repository
public interface UacGroupMapper extends MyMapper<UacGroup> {

}
