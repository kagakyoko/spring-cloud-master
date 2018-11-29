package com.pass.cloud.mdc.mapper;

import java.util.List;

import com.pass.cloud.core.mybatis.MyMapper;
import com.pass.cloud.mdc.model.domain.MdcProductCategory;
import com.pass.cloud.mdc.model.dto.ProductCategoryDto;
import com.pass.cloud.mdc.model.vo.MdcCategoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author takesi
 */
@Mapper
@Repository
public interface MdcProductCategoryMapper extends MyMapper<MdcProductCategory> {

    /**
     * Select category dto list list.
     *
     * @param categoryPid the category pid
     * @return the list
     */
    List<ProductCategoryDto> selectCategoryDtoList(Long categoryPid);

    /**
     * List category vo list.
     *
     * @return the list
     */
    List<MdcCategoryVo> listCategoryVo();

}
