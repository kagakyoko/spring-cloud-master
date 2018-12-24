package com.pass.cloud.mdc.service.impl;

import com.github.pagehelper.PageInfo;
import com.pass.cloud.core.support.BaseService;
import com.pass.cloud.mdc.mapper.MdcExceptionLogMapper;
import com.pass.cloud.mdc.model.domain.MdcExceptionLog;
import com.pass.cloud.mdc.model.dto.GlobalExceptionLogDto;
import com.pass.cloud.mdc.model.dto.MdcExceptionQueryDto;
import com.pass.cloud.mdc.service.MdcExceptionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author takesi
 */
@Service
public class MdcExceptionLogServiceImpl extends BaseService<MdcExceptionLog> implements MdcExceptionLogService {

    @Autowired
    private MdcExceptionLogMapper mdcExceptionLogMapper;

    @Override
    public void saveAndSendExceptionLog(GlobalExceptionLogDto exceptionLogDto) {

    }

    @Override
    public PageInfo queryExceptionListWithPage(MdcExceptionQueryDto mdcExceptionQueryDto) {
        return null;
    }

}
