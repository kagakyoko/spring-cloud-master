package com.pass.cloud.mdc.service.hystrix;

import com.pass.cloud.mdc.model.dto.ProductDto;
import com.pass.cloud.mdc.model.vo.ProductDetailVo;
import com.pass.cloud.mdc.service.MdcProductQueryFeignApi;

import org.springframework.stereotype.Component;

/**
 * @author takesi
 */
@Component
public class MdcProductQueryFeignHystrix implements MdcProductQueryFeignApi {

    @Override
    public ProductDetailVo getProductDetail(Long productId) {
        return null;
    }

    @Override
    public ProductDto selectById(Long productId) {
        return null;
    }

}
