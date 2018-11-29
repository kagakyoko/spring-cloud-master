package com.pass.cloud.mdc.mapper;

import java.util.List;

import com.pass.cloud.core.mybatis.MyMapper;
import com.pass.cloud.mdc.model.domain.MdcDict;
import com.pass.cloud.mdc.model.vo.MdcDictVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author takesi
 */
@Mapper
@Repository
public interface MdcDictMapper extends MyMapper<MdcDict> {

    /**
     * List dict vo list.
     *
     * @return the list
     */
    List<MdcDictVo> listDictVo();

}
