package com.pass.cloud.mdc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pass.cloud.annotation.NoNeedAccessAuthentication;
import com.pass.cloud.mdc.model.dto.ProductCategoryDto;
import com.pass.cloud.mdc.model.dto.ProductReqDto;

/**
 * @author takesi
 */
public interface MdcProductCategoryQueryFeignApi {

    /**
     * 查询分类信息.
     *
     * @param pid the pid
     * @return the product category data
     */
    @NoNeedAccessAuthentication
    List<ProductCategoryDto> getProductCategoryData(Long pid);

    /**
     * 查询商品列表.
     *
     * @param productReqDto the product req dto
     * @return the product list
     */
    @NoNeedAccessAuthentication
    PageInfo getProductList(ProductReqDto productReqDto);

}
