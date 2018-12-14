package com.pass.cloud.mdc.service;

import com.pass.cloud.mdc.model.dto.GlobalExceptionLogDto;

/**
 * @author takesi
 */
public interface MdcExceptionLogFeignApi {

    /**
     * Update product stock by id
     *
     * @param exceptionLogDto
     */
    void saveAndSendExceptionLog(GlobalExceptionLogDto exceptionLogDto);

}
