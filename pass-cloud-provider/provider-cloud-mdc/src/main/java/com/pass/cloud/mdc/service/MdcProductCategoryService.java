package com.pass.cloud.mdc.service;

import java.util.List;

import com.pass.cloud.core.support.IService;
import com.pass.cloud.mdc.model.domain.MdcProductCategory;
import com.pass.cloud.mdc.model.dto.ProductCategoryDto;
import com.pass.cloud.mdc.model.vo.MdcCategoryVo;

/**
 * @author takesi
 */
public interface MdcProductCategoryService extends IService<MdcProductCategory> {

    /**
     * Gets category dto list.
     *
     * @param categoryId the category id
     * @return the category dto list
     */
    List<ProductCategoryDto> getCategoryDtoList(Long categoryId);

    /**
     * Gets product category list by pid.
     *
     * @param pid the pid
     * @return the product category list by pid
     */
    List<MdcProductCategory> getProductCategoryListByPid(Long pid);

    /**
     * 递归查询本节点的id及孩子节点的id.
     *
     * @param categoryId the category id
     * @return the list
     */
    List<Long> selectCategoryAndChildrenById(Long categoryId);

    /**
     * Gets by category id.
     *
     * @param categoryId the category id
     * @return the by category id
     */
    MdcProductCategory getByCategoryId(Long categoryId);

    /**
     * 获取商品分类树.
     *
     * @return the category tree list
     */
    List<MdcCategoryVo> getCategoryTreeList();

    /**
     * 根据ID获取商品分类信息.
     *
     * @param id the id
     * @return the mdc category vo by id
     */
    MdcCategoryVo getMdcCategoryVoById(Long id);

    /**
     * Check category has child category boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean checkCategoryHasChildCategory(Long id);

}
