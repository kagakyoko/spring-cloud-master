package com.pass.cloud.mdc.web.frontend;

import com.pass.cloud.core.support.BaseController;
import com.pass.cloud.mdc.model.domain.MdcProductCategory;
import com.pass.cloud.mdc.model.dto.MdcCategoryCheckNameDto;
import com.pass.cloud.mdc.service.MdcProductCategoryService;
import com.pass.cloud.wrapper.WrapMapper;
import com.pass.cloud.wrapper.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

/**
 * @author takesi
 */
@RestController
@RequestMapping(value = "/dict", produces = MediaType.APPLICATION_JSON_VALUE)
public class UacProductCategoryCommonController extends BaseController {

    @Autowired
    private MdcProductCategoryService mdcProductCategoryService;

    /**
     * 检测数据分类名称是否已存在.
     *
     * @param categoryCheckNameDto the category check name dto
     * @return the wrapper
     */
    @RequestMapping(value = "/checkCategoryName", method = RequestMethod.OPTIONS)
    public Wrapper<Boolean> checkCategoryName(@RequestBody MdcCategoryCheckNameDto categoryCheckNameDto) {
        logger.info("检测数据分类名称是否已存在 categoryCheckNameDto={}", categoryCheckNameDto);

        Long id = categoryCheckNameDto.getCategoryId();
        String categoryName = categoryCheckNameDto.getCategoryName();

        Example example = new Example(MdcProductCategory.class);
        Example.Criteria criteria = example.createCriteria();

        if (id != null) {
            criteria.andNotEqualTo("id", id);
        }
        criteria.andEqualTo("name", categoryName);

        int result = mdcProductCategoryService.selectCountByExample(example);
        return WrapMapper.ok(result < 1);
    }

}
