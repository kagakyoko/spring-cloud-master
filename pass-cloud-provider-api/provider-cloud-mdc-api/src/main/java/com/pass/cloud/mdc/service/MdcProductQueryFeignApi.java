package com.pass.cloud.mdc.service;

import com.pass.cloud.annotation.NoNeedAccessAuthentication;
import com.pass.cloud.mdc.model.dto.ProductDto;
import com.pass.cloud.mdc.model.vo.ProductDetailVo;
import com.pass.cloud.mdc.service.hystrix.MdcProductQueryFeignHystrix;
import com.pass.cloud.security.feign.Oauth2FeignAutoConfiguration;
import com.pass.cloud.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author takesi
 */
@FeignClient(value = "passcloud-provider-mdc", configuration = Oauth2FeignAutoConfiguration.class, fallback = MdcProductQueryFeignHystrix.class)
public interface MdcProductQueryFeignApi {

    /**
     * 查询商品详情信息.
     *
     * @param productId the product id
     * @return the product detail
     */
    @NoNeedAccessAuthentication
    @GetMapping(value = "/api/product/getProductDetail/{productId}")
    Wrapper<ProductDetailVo> getProductDetail(@PathVariable("productId") Long productId);

    /**
     * Select by id wrapper.
     *
     * @param productId the product id
     * @return the wrapper
     */
    @NoNeedAccessAuthentication
    @GetMapping(value = "/api/product/selectById/{productId}")
    Wrapper<ProductDto> selectById(@PathVariable("productId") Long productId);

}
