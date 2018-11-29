package com.pass.cloud.mdc.service;

import java.util.List;

import com.pass.cloud.core.support.IService;
import com.pass.cloud.mdc.model.domain.MdcProduct;
import com.pass.cloud.mdc.model.dto.ProductDto;
import com.pass.cloud.mdc.model.vo.ProductDetailVo;
import com.pass.cloud.mdc.model.vo.ProductVo;

/**
 * @author takesi
 */
public interface MdcProductService extends IService<MdcProduct> {

    /**
     * Select by name and category ids list.
     *
     * @param productName    the product name
     * @param categoryIdList the category id list
     * @param orderBy        the order by
     * @return the list
     */
    List<MdcProduct> selectByNameAndCategoryIds(String productName, List<Long> categoryIdList, String orderBy);

    /**
     * 根据商品ID查询商品详细信息.
     *
     * @param productId the product id
     * @return the product detail
     */
    ProductDetailVo getProductDetail(Long productId);

    /**
     * 更新商品库存.
     *
     * @param productDto the product dto
     * @return the int
     */
    int updateProductStockById(ProductDto productDto);

    /**
     * 查询商品集合.
     *
     * @param mdcProduct the mdc product
     * @return the list
     */
    List<ProductVo> queryProductListWithPage(MdcProduct mdcProduct);

    /**
     * 删除商品信息.
     *
     * @param id the id
     */
    void deleteProductById(Long id);

    /**
     * Gets product vo.
     *
     * @param id the id
     * @return the product vo
     */
    ProductVo getProductVo(Long id);

    /**
     * Gets main image.
     *
     * @param productId the product id
     * @return the main image
     */
    String getMainImage(Long productId);

}
