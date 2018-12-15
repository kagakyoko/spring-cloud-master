package com.pass.cloud.mdc.mapper;

import java.util.List;

import com.pass.cloud.core.mybatis.MyMapper;
import com.pass.cloud.mdc.model.domain.MdcExceptionLog;
import com.pass.cloud.mdc.model.dto.MdcExceptionQueryDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author takesi
 */
@Mapper
@Repository
public interface MdcExceptionLogMapper extends MyMapper<MdcExceptionLog> {

    /**
     * Query exception list with page list.
     *
     * @param mdcExceptionQueryDto the mdc exception query dto
     * @return the list
     */
    List<MdcExceptionLog> queryExceptionListWithPage(MdcExceptionQueryDto mdcExceptionQueryDto);

}
