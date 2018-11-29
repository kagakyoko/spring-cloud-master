package com.pass.cloud.mdc.service.impl;

import java.util.List;

import com.pass.cloud.base.enums.ErrorCodeEnum;
import com.pass.cloud.core.support.BaseService;
import com.pass.cloud.core.support.TreeUtils;
import com.pass.cloud.mdc.exception.MdcBizException;
import com.pass.cloud.mdc.mapper.MdcDictMapper;
import com.pass.cloud.mdc.model.domain.MdcDict;
import com.pass.cloud.mdc.model.enums.MdcDictStatusEnum;
import com.pass.cloud.mdc.model.vo.MdcDictVo;
import com.pass.cloud.mdc.service.MdcDictService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author takesi
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MdcDictServiceImpl extends BaseService<MdcDict> implements MdcDictService {

    @Autowired
    private MdcDictMapper mdcDictMapper;

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<MdcDictVo> getDictTreeList() {
        List<MdcDictVo> list = mdcDictMapper.listDictVo();
        return new TreeUtils().getChildTreeObjects(list, 0L);
    }

    @Override
    public MdcDictVo getMdcDictVoById(Long dictId) {
        MdcDict dict = mdcDictMapper.selectByPrimaryKey(dictId);

        if (dict == null) {
            throw new MdcBizException(ErrorCodeEnum.MDC10021018, dictId);
        }

        // 获取父级菜单信息
        MdcDict parentDict = mdcDictMapper.selectByPrimaryKey(dict.getPid());

        ModelMapper modelMapper = new ModelMapper();
        MdcDictVo dictVo = modelMapper.map(dict, MdcDictVo.class);

        if (parentDict != null) {
            dictVo.setParentDictName(parentDict.getDictName());
        }

        return dictVo;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public boolean checkDictHasChildDict(Long dictId) {
        MdcDict uacMenu = new MdcDict();
        uacMenu.setStatus(MdcDictStatusEnum.ENABLE.getType());
        uacMenu.setPid(dictId);

        return mapper.selectCount(uacMenu) > 0;
    }
}
