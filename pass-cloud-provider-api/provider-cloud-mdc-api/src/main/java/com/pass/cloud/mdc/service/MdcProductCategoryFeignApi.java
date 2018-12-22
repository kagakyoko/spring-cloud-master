package com.pass.cloud.mdc.service;

import com.pass.cloud.mdc.service.hystrix.MdcProductCategoryFeignHystrix;
import com.pass.cloud.security.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author takesi
 */
@FeignClient(value = "passcloud-provider-mdc", configuration = OAuth2FeignAutoConfiguration.class, fallback = MdcProductCategoryFeignHystrix.class)
public interface MdcProductCategoryFeignApi {

}
