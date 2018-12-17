package com.pass.cloud.mdc.web.frontend;

import java.util.List;

import com.pass.cloud.base.dto.LoginAuthDto;
import com.pass.cloud.base.dto.UpdateStatusDto;
import com.pass.cloud.core.support.BaseController;
import com.pass.cloud.mdc.model.domain.MdcProductCategory;
import com.pass.cloud.mdc.model.dto.MdcEditCategoryDto;
import com.pass.cloud.mdc.model.vo.MdcCategoryVo;
import com.pass.cloud.mdc.service.MdcProductCategoryService;
import com.pass.cloud.wrapper.WrapMapper;
import com.pass.cloud.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author takesi
 */
@RestController
@RequestMapping(value = "/category")
@Api(value = "WEB - MdcProductCategoryRestController", tags = "MdcProductCategoryRestController", produces = MediaType.APPLICATION_JSON_VALUE)
public class MdcProductCategoryRestController extends BaseController {

    @Autowired
    private MdcProductCategoryService mdcProductCategoryService;

    /**
     * 获取商品分类列表数据
     *
     * @return the wrapper
     */
    @ApiOperation(httpMethod = "GET", value = "获取商品分类树")
    @GetMapping(value = "/getTree", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wrapper<List> queryCategoryTreeList() {
        List<MdcCategoryVo> categoryVoList = mdcProductCategoryService.getCategoryTreeList();
        return WrapMapper.ok(categoryVoList);
    }

    /**
     * 根据ID获取商品分类信息.
     *
     * @param id the id
     * @return the wrapper
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID获取商品分类信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品分类id", type = "path", required = true, dataType = "Long")
    })
    @GetMapping(value = "/queryById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wrapper<MdcCategoryVo> queryCategoryVoById(@PathVariable Long id) {
        MdcCategoryVo mdcCategoryVo = mdcProductCategoryService.getMdcCategoryVoById(id);
        return WrapMapper.ok(mdcCategoryVo);
    }

    /**
     * 根据id修改商品分类的禁用状态
     *
     * @return the wrapper
     */
    @ApiOperation(httpMethod = "POST", value = "根据id修改商品分类的禁用状态")
    @PatchMapping(value = "/modifyStatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wrapper updateMdcCategoryStatusById(@ApiParam(name = "mdcCategoryStatusDto", value = "修改商品分类状态Dto") @RequestBody UpdateStatusDto updateStatusDto) {
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        mdcProductCategoryService.updateMdcCategoryStatusById(updateStatusDto, loginAuthDto);
        return WrapMapper.ok();
    }

    @ApiOperation(httpMethod = "POST", value = "编辑商品分类")
    @PutMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wrapper saveCategory(@ApiParam(name = "saveCategory", value = "编辑商品分类") @RequestBody MdcEditCategoryDto mdcCategoryAddDto) {
        MdcProductCategory mdcCategory = new MdcProductCategory();
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        BeanUtils.copyProperties(mdcCategoryAddDto, mdcCategory);
        mdcProductCategoryService.saveMdcCategory(mdcCategory, loginAuthDto);
        return WrapMapper.ok();
    }

    /**
     * 根据id删除商品分类
     *
     * @param id the id
     * @return the wrapper
     */
    @ApiOperation(httpMethod = "DELETE", value = "根据id删除商品分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品分类id", type = "path", required = true, dataType = "Long")
    })
    @DeleteMapping(value = "/deleteById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wrapper<Integer> deleteMdcCategoryById(@PathVariable Long id) {
        // 判断此商品分类是否有子节点
        boolean hasChild = mdcProductCategoryService.checkCategoryHasChildCategory(id);
        if (hasChild) {
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "此商品分类含有子商品分类, 请先删除子商品分类");
        }

        int result = mdcProductCategoryService.deleteByKey(id);
        return super.handleResult(result);
    }

}
