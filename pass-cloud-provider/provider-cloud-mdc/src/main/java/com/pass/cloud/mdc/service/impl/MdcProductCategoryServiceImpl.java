package com.pass.cloud.mdc.service.impl;

import java.util.List;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.pass.cloud.base.enums.ErrorCodeEnum;
import com.pass.cloud.core.support.BaseService;
import com.pass.cloud.core.support.TreeUtils;
import com.pass.cloud.mdc.exception.MdcBizException;
import com.pass.cloud.mdc.mapper.MdcProductCategoryMapper;
import com.pass.cloud.mdc.model.domain.MdcProductCategory;
import com.pass.cloud.mdc.model.dto.ProductCategoryDto;
import com.pass.cloud.mdc.model.enums.MdcCategoryStatusEnum;
import com.pass.cloud.mdc.model.vo.MdcCategoryVo;
import com.pass.cloud.mdc.service.MdcProductCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author takesi
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MdcProductCategoryServiceImpl extends BaseService<MdcProductCategory> implements MdcProductCategoryService {

    @Autowired
    private MdcProductCategoryMapper mdcProductCategoryMapper;

    @Override
    public List<ProductCategoryDto> getCategoryDtoList(Long categoryId) {
        return mdcProductCategoryMapper.selectCategoryDtoList(categoryId);
    }

    @Override
    public List<Long> selectCategoryAndChildrenById(Long categoryId) {
        Set<MdcProductCategory> categorySet = Sets.newHashSet();
        findChildCategory(categorySet, categoryId);


        List<Long> categoryIdList = Lists.newArrayList();
        if (categoryId != null) {
            for (MdcProductCategory categoryItem : categorySet) {
                categoryIdList.add(categoryItem.getId());
            }
        }
        return categoryIdList;
    }

    @Override
    public MdcProductCategory getByCategoryId(Long categoryId) {
        Preconditions.checkArgument(categoryId != null, "分类ID不能为空");

        MdcProductCategory query = new MdcProductCategory();
        query.setId(categoryId);
        return mdcProductCategoryMapper.selectOne(query);
    }

    @Override
    public List<MdcCategoryVo> getCategoryTreeList() {
        List<MdcCategoryVo> list = mdcProductCategoryMapper.listCategoryVo();
        return new TreeUtils().getChildTreeObjects(list, 0L);
    }

    @Override
    public MdcCategoryVo getMdcCategoryVoById(final Long categoryId) {
        MdcProductCategory category = mdcProductCategoryMapper.selectByPrimaryKey(categoryId);

        if (category == null) {
            throw new MdcBizException(ErrorCodeEnum.MDC10023001, categoryId);
        }

        // 获取父级菜单信息
        MdcProductCategory parentCategory = mdcProductCategoryMapper.selectByPrimaryKey(category.getPid());

        ModelMapper modelMapper = new ModelMapper();
        MdcCategoryVo categoryVo = modelMapper.map(category, MdcCategoryVo.class);
        categoryVo.setId(category.getId());
        categoryVo.setPid(category.getPid());
        if (parentCategory != null) {
            categoryVo.setParentCategoryName(parentCategory.getName());
        }

        return categoryVo;
    }

    @Override
    public boolean checkCategoryHasChildCategory(final Long categoryId) {
        MdcProductCategory uacMenu = new MdcProductCategory();
        uacMenu.setStatus(MdcCategoryStatusEnum.ENABLE.getType());
        uacMenu.setPid(categoryId);

        return mapper.selectCount(uacMenu) > 0;
    }

    /**
     * 递归算法,算出子节点
     */
    private Set<MdcProductCategory> findChildCategory(Set<MdcProductCategory> categorySet, Long categoryId) {
        MdcProductCategory category = mdcProductCategoryMapper.selectByPrimaryKey(categoryId);
        if (category != null) {
            categorySet.add(category);
        }
        //查找子节点,递归算法一定要有一个退出的条件
        List<MdcProductCategory> categoryList = this.getProductCategoryListByPid(categoryId);
        for (MdcProductCategory categoryItem : categoryList) {
            findChildCategory(categorySet, categoryItem.getId());
        }
        return categorySet;
    }

    @Override
    public List<MdcProductCategory> getProductCategoryListByPid(Long pid) {
        Preconditions.checkArgument(pid != null, "pid is null");
        MdcProductCategory query = new MdcProductCategory();
        query.setPid(pid);

        return mdcProductCategoryMapper.select(query);
    }

}
