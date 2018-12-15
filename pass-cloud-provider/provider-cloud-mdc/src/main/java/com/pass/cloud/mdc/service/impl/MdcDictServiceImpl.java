package com.pass.cloud.mdc.service.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.pass.cloud.base.dto.LoginAuthDto;
import com.pass.cloud.base.dto.UpdateStatusDto;
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
    public void updateMdcDictStatusById(UpdateStatusDto updateStatusDto, LoginAuthDto loginAuthDto) {
        Long id = updateStatusDto.getId();
        Integer status = updateStatusDto.getStatus();
        // 要处理的菜单集合
        List<MdcDict> mdcDictList = Lists.newArrayList();

        int result;
        if (status.equals(MdcDictStatusEnum.DISABLE.getType())) {
            // 获取菜单以及子菜单
            mdcDictList = this.getAllDictFolder(id, MdcDictStatusEnum.ENABLE.getType());
        } else {
            // 获取菜单、其子菜单以及父菜单
            MdcDict uacMenu = new MdcDict();
            uacMenu.setPid(id);
            result = this.selectCount(uacMenu);
            // 此菜单含有子菜单
            if (result > 0) {
                mdcDictList = this.getAllDictFolder(id, MdcDictStatusEnum.DISABLE.getType());
            }
            List<MdcDict> dictListTemp = this.getAllParentDictFolderByMenuId(id);
            for (MdcDict dict : dictListTemp) {
                if (!mdcDictList.contains(dict)) {
                    mdcDictList.add(dict);
                }
            }
        }

        this.updateDictStatus(mdcDictList, loginAuthDto, status);
    }

    @Override
    public void saveMdcDict(MdcDict mdcDict, LoginAuthDto loginAuthDto) {

    }

    @Override
    public boolean checkDictHasChildDict(Long dictId) {
        MdcDict uacMenu = new MdcDict();
        uacMenu.setStatus(MdcDictStatusEnum.ENABLE.getType());
        uacMenu.setPid(dictId);

        return mapper.selectCount(uacMenu) > 0;
    }

    private void updateDictStatus(List<MdcDict> mdcDictList, LoginAuthDto loginAuthDto, int status) {
        MdcDict update = new MdcDict();
        for (MdcDict dict : mdcDictList) {
            update.setId(dict.getId());
            update.setVersion(dict.getVersion() + 1);
            update.setStatus(status);
            update.setUpdateInfo(loginAuthDto);
            int result = mapper.updateByPrimaryKeySelective(update);
            if (result < 1) {
                throw new MdcBizException(ErrorCodeEnum.MDC10021019, dict.getId());
            }
        }
    }

    private List<MdcDict> getAllDictFolder(Long id, int dictStatus) {
        MdcDict mdcDict = new MdcDict();
        mdcDict.setId(id);
        mdcDict = mapper.selectOne(mdcDict);
        List<MdcDict> mdcDictList = Lists.newArrayList();
        mdcDictList = buildNode(mdcDictList, mdcDict, dictStatus);
        return mdcDictList;
    }

    private List<MdcDict> getAllParentDictFolderByMenuId(Long dictId) {
        MdcDict mdcDictQuery = new MdcDict();
        mdcDictQuery.setId(dictId);
        mdcDictQuery = mapper.selectOne(mdcDictQuery);
        List<MdcDict> mdcDictList = Lists.newArrayList();
        mdcDictList = buildParentNote(mdcDictList, mdcDictQuery);
        return mdcDictList;
    }

    /**
     * 递归获取菜单的子节点
     */
    private List<MdcDict> buildNode(List<MdcDict> mdcDictList, MdcDict uacMenu, int dictStatus) {
        List<MdcDict> uacMenuQueryList = mapper.select(uacMenu);
        MdcDict uacMenuQuery;
        for (MdcDict dict : uacMenuQueryList) {
            if (dictStatus == dict.getStatus()) {
                mdcDictList.add(dict);
            }
            uacMenuQuery = new MdcDict();
            uacMenuQuery.setPid(dict.getId());
            buildNode(mdcDictList, uacMenuQuery, dictStatus);
        }
        return mdcDictList;
    }

    /**
     * 递归获取菜单的父菜单
     */
    private List<MdcDict> buildParentNote(List<MdcDict> mdcDictList, MdcDict mdcDict) {
        List<MdcDict> mdcDictQueryList = mapper.select(mdcDict);
        MdcDict uacMenuQuery;
        for (MdcDict dict : mdcDictQueryList) {
            if (MdcDictStatusEnum.DISABLE.getType() == dict.getStatus()) {
                mdcDictList.add(dict);
            }
            uacMenuQuery = new MdcDict();
            uacMenuQuery.setId(dict.getPid());
            buildParentNote(mdcDictList, uacMenuQuery);
        }
        return mdcDictList;
    }

}
