package com.pass.cloud.mdc.service;

import com.pass.cloud.mdc.service.hystrix.MdcProductCategoryFeignHystrix;
import com.pass.cloud.security.feign.Oauth2FeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author takesi
 */
@FeignClient(value = "passcloud-provider-mdc", configuration = Oauth2FeignAutoConfiguration.class, fallback = MdcProductCategoryFeignHystrix.class)
public interface MdcProductCategoryFeignApi {

}
