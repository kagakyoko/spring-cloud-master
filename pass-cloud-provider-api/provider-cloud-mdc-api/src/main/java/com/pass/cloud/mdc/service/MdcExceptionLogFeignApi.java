package com.pass.cloud.mdc.service;

import com.pass.cloud.mdc.model.dto.GlobalExceptionLogDto;
import com.pass.cloud.mdc.service.hystrix.MdcExceptionLogFeignHystrix;
import com.pass.cloud.security.feign.Oauth2FeignAutoConfiguration;
import com.pass.cloud.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author takesi
 */
@FeignClient(value = "passcloud-provider-mdc", configuration = Oauth2FeignAutoConfiguration.class, fallback = MdcExceptionLogFeignHystrix.class)
public interface MdcExceptionLogFeignApi {

    /**
     * Update product stock by id
     *
     * @param exceptionLogDto
     * @return
     */
    @PutMapping(value = "/api/exception/saveAndSendExceptionLog")
    Wrapper saveAndSendExceptionLog(GlobalExceptionLogDto exceptionLogDto);

}
