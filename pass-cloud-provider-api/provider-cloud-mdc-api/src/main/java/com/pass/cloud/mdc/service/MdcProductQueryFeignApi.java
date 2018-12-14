package com.pass.cloud.mdc.service;

import com.pass.cloud.annotation.NoNeedAccessAuthentication;
import com.pass.cloud.mdc.model.dto.ProductDto;
import com.pass.cloud.mdc.model.vo.ProductDetailVo;

/**
 * @author takesi
 */
public interface MdcProductQueryFeignApi {

    /**
     * 查询商品详情信息.
     *
     * @param productId the product id
     * @return the product detail
     */
    @NoNeedAccessAuthentication
    ProductDetailVo getProductDetail(Long productId);

    /**
     * Select by id wrapper.
     *
     * @param productId the product id
     * @return the wrapper
     */
    @NoNeedAccessAuthentication
    ProductDto selectById(Long productId);

}
