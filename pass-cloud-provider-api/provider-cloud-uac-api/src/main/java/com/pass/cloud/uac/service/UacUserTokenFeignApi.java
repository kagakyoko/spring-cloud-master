package com.pass.cloud.uac.service;

import com.pass.cloud.security.feign.Oauth2FeignAutoConfiguration;
import com.pass.cloud.uac.service.hystrix.UacUserTokenFeignApiHystrix;
import com.pass.cloud.wrapper.Wrapper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author takesi
 */
@FeignClient(value = "passcloud-provider-uac", configuration = Oauth2FeignAutoConfiguration.class, fallback = UacUserTokenFeignApiHystrix.class)
public interface UacUserTokenFeignApi {

    /**
     * 超时token更新为离线.
     *
     * @return the wrapper
     */
    @PutMapping(value = "/api/uac/token/updateTokenOffLine")
    Wrapper<Integer> updateTokenOffLine();

}
