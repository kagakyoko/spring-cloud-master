package com.pass.cloud.mdc.service;

import com.github.pagehelper.PageInfo;
import com.pass.cloud.core.support.IService;
import com.pass.cloud.mdc.model.domain.MdcExceptionLog;
import com.pass.cloud.mdc.model.dto.GlobalExceptionLogDto;
import com.pass.cloud.mdc.model.dto.MdcExceptionQueryDto;

/**
 * @author takesi
 */
public interface MdcExceptionLogService extends IService<MdcExceptionLog> {

    /**
     * 保存日志并发送钉钉消息.
     *
     * @param exceptionLogDto the exception log dto
     */
    void saveAndSendExceptionLog(GlobalExceptionLogDto exceptionLogDto);

    /**
     * Query exception list with page page info.
     *
     * @param mdcExceptionQueryDto the mdc exception query dto
     * @return the page info
     */
    PageInfo queryExceptionListWithPage(MdcExceptionQueryDto mdcExceptionQueryDto);

}
