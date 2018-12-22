package com.pass.cloud.mdc.service.hystrix;

import com.pass.cloud.mdc.model.dto.GlobalExceptionLogDto;
import com.pass.cloud.mdc.service.MdcExceptionLogFeignApi;

import com.pass.cloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;

/**
 * @author takesi
 */
@Component
public class MdcExceptionLogFeignHystrix implements MdcExceptionLogFeignApi {

    @Override
    public Wrapper saveAndSendExceptionLog(GlobalExceptionLogDto exceptionLogDto) {
        return null;
    }

}
