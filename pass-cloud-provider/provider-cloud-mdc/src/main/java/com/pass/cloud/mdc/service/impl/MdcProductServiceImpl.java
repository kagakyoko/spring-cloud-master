package com.pass.cloud.mdc.service.impl;

import java.util.List;

import com.google.common.base.Preconditions;
import com.pass.cloud.PubUtils;
import com.pass.cloud.base.enums.ErrorCodeEnum;
import com.pass.cloud.core.support.BaseService;
import com.pass.cloud.mdc.mapper.MdcProductMapper;
import com.pass.cloud.mdc.model.domain.MdcProduct;
import com.pass.cloud.mdc.model.dto.ProductDto;
import com.pass.cloud.mdc.model.vo.ProductDetailVo;
import com.pass.cloud.mdc.model.vo.ProductVo;
import com.pass.cloud.mdc.service.MdcProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author takesi
 */
@Service
public class MdcProductServiceImpl extends BaseService<MdcProduct> implements MdcProductService {

    @Autowired
    private MdcProductMapper mdcProductMapper;

    @Override
    public List<MdcProduct> selectByNameAndCategoryIds(String productName, List<Long> categoryIdList, String orderBy) {
        return mdcProductMapper.selectByNameAndCategoryIds(productName, categoryIdList, orderBy);
    }

    @Override
    public ProductDetailVo getProductDetail(Long productId) {
        Preconditions.checkArgument(productId != null, ErrorCodeEnum.MDC10021021.msg());
        return null;
    }

    @Override
    public int updateProductStockById(ProductDto productDto) {
        Preconditions.checkArgument(!PubUtils.isNull(productDto, productDto.getId()), ErrorCodeEnum.MDC10021021.msg());
        return mdcProductMapper.updateProductStockById(productDto);
    }

    @Override
    public List<ProductVo> queryProductListWithPage(MdcProduct mdcProduct) {
        return mdcProductMapper.queryProductListWithPage(mdcProduct);
    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public ProductVo getProductVo(Long id) {
        return null;
    }

    @Override
    public String getMainImage(Long productId) {
        return null;
    }

}
