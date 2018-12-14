package com.pass.cloud.mdc.service.hystrix;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pass.cloud.mdc.model.dto.ProductCategoryDto;
import com.pass.cloud.mdc.model.dto.ProductReqDto;
import com.pass.cloud.mdc.service.MdcProductCategoryQueryFeignApi;

import org.springframework.stereotype.Component;

/**
 * @author takesi
 */
@Component
public class MdcProductCategoryQueryFeignHystrix implements MdcProductCategoryQueryFeignApi {

    @Override
    public List<ProductCategoryDto> getProductCategoryData(Long pid) {
        return null;
    }

    @Override
    public PageInfo getProductList(ProductReqDto productReqDto) {
        return null;
    }

}
