package com.pass.cloud.mdc.service;

import com.pass.cloud.mdc.model.dto.ProductDto;

/**
 * @author takesi
 */
public interface MdcProductFeignApi {

    /**
     * Update product stock by id int.
     *
     * @param productDto the product dto
     * @return the int
     */
    Integer updateProductStockById(ProductDto productDto);

    /**
     * Gets main image.
     *
     * @param productId the product
     *                  id
     * @return the main image
     */
    String getMainImage(Long productId);

}
