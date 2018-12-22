package com.pass.cloud.mdc.service;

import com.pass.cloud.mdc.model.dto.ProductDto;
import com.pass.cloud.mdc.service.hystrix.MdcProductFeignHystrix;
import com.pass.cloud.security.feign.OAuth2FeignAutoConfiguration;
import com.pass.cloud.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author takesi
 */
@FeignClient(value = "passcloud-provider-mdc", configuration = OAuth2FeignAutoConfiguration.class, fallback = MdcProductFeignHystrix.class)
public interface MdcProductFeignApi {

    /**
     * Update product stock by id int.
     *
     * @param productDto the product dto
     * @return the int
     */
    @GetMapping(value = "/api/product/updateProductStockById")
    Wrapper<Integer> updateProductStockById(ProductDto productDto);

    /**
     * Gets main image.
     *
     * @param productId the product
     *                  id
     * @return the main image
     */
    @GetMapping(value = "/api/product/getMainImage")
    Wrapper<String> getMainImage(@RequestParam("productId") Long productId);

}
