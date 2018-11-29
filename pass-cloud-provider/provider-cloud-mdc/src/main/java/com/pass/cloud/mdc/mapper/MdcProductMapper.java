package com.pass.cloud.mdc.mapper;

import java.util.List;

import com.pass.cloud.core.mybatis.MyMapper;
import com.pass.cloud.mdc.model.domain.MdcProduct;
import com.pass.cloud.mdc.model.dto.ProductDto;
import com.pass.cloud.mdc.model.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author takesi
 */
@Mapper
@Repository
public interface MdcProductMapper extends MyMapper<MdcProduct> {

    /**
     * Select by name and category ids list.
     *
     * @param productName    the product name
     * @param categoryIdList the category id list
     * @param orderBy        the order by
     * @return the list
     */
    List<MdcProduct> selectByNameAndCategoryIds(@Param("productName") String productName, @Param("categoryIdList") List<Long> categoryIdList, @Param("orderBy") String orderBy);

    /**
     * Update product stock by id int.
     *
     * @param productDto the product dto
     * @return the int
     */
    int updateProductStockById(ProductDto productDto);

    /**
     * Query product list with page list.
     *
     * @param mdcProduct the mdc product
     * @return the list
     */
    List<ProductVo> queryProductListWithPage(MdcProduct mdcProduct);

}
