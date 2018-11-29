package com.pass.cloud.mdc.service;

import java.util.List;

import com.pass.cloud.core.support.IService;
import com.pass.cloud.mdc.model.domain.MdcDict;
import com.pass.cloud.mdc.model.vo.MdcDictVo;

/**
 * @author takesi
 */
public interface MdcDictService extends IService<MdcDict> {

    /**
     * 获取字典树.
     *
     * @return the dict tree list
     */
    List<MdcDictVo> getDictTreeList();

    /**
     * 根据ID获取字典信息.
     *
     * @param dictId the dict id
     * @return the mdc dict vo by id
     */
    MdcDictVo getMdcDictVoById(Long dictId);

    /**
     * Check dict has child dict boolean.
     *
     * @param dictId the dict id
     * @return the boolean
     */
    boolean checkDictHasChildDict(Long dictId);

}
