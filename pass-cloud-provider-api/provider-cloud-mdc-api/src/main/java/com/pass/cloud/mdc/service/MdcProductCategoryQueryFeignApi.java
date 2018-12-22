package com.pass.cloud.mdc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pass.cloud.annotation.NoNeedAccessAuthentication;
import com.pass.cloud.mdc.model.dto.ProductCategoryDto;
import com.pass.cloud.mdc.model.dto.ProductReqDto;
import com.pass.cloud.mdc.service.hystrix.MdcProductCategoryQueryFeignHystrix;
import com.pass.cloud.security.feign.OAuth2FeignAutoConfiguration;
import com.pass.cloud.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author takesi
 */
@FeignClient(value = "passcloud-provider-mdc", configuration = OAuth2FeignAutoConfiguration.class, fallback = MdcProductCategoryQueryFeignHystrix.class)
public interface MdcProductCategoryQueryFeignApi {

    /**
     * 查询分类信息.
     *
     * @param pid the pid
     * @return the product category data
     */
    @NoNeedAccessAuthentication
    @GetMapping(value = "/api/productCategory/getProductCategoryDtoByPid/{pid}")
    Wrapper<List<ProductCategoryDto>> getProductCategoryData(@PathVariable("pid") Long pid);

    /**
     * 查询商品列表.
     *
     * @param productReqDto the product req dto
     * @return the product list
     */
    @NoNeedAccessAuthentication
    @GetMapping(value = "/api/product/getProductList")
    Wrapper<PageInfo> getProductList(ProductReqDto productReqDto);

}
