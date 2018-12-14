package com.pass.cloud.mdc.service.hystrix;

import com.pass.cloud.mdc.model.dto.ProductDto;
import com.pass.cloud.mdc.service.MdcProductFeignApi;

import org.springframework.stereotype.Component;

/**
 * @author takesi
 */
@Component
public class MdcProductFeignHystrix implements MdcProductFeignApi {

    @Override
    public Integer updateProductStockById(ProductDto productDto) {
        return null;
    }

    @Override
    public String getMainImage(Long productId) {
        return null;
    }

}
