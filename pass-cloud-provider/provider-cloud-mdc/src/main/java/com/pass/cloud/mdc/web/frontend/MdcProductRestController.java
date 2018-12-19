package com.pass.cloud.mdc.web.frontend;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pass.cloud.core.support.BaseController;
import com.pass.cloud.mdc.model.domain.MdcProduct;
import com.pass.cloud.mdc.model.dto.MdcEditProductDto;
import com.pass.cloud.mdc.model.vo.ProductVo;
import com.pass.cloud.mdc.service.MdcProductService;
import com.pass.cloud.wrapper.WrapMapper;
import com.pass.cloud.wrapper.Wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author takesi
 */
@RestController
@RequestMapping(value = "/product")
public class MdcProductRestController extends BaseController {

    @Autowired
    private MdcProductService mdcProductService;

    /**
     * 分页查询商品列表.
     *
     * @return the wrapper
     */
    @GetMapping(value = "/queryProductListWithPage", produces = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<ProductVo> queryProductListWithPage(MdcProduct mdcProduct) {
        PageHelper.startPage(mdcProduct.getPageNum(), mdcProduct.getPageSize());
        mdcProduct.setOrderBy("update_time desc");
        List<ProductVo> roleVoList = mdcProductService.queryProductListWithPage(mdcProduct);
        return new PageInfo<>(roleVoList);
    }

    /**
     * 商品详情.
     */
    @GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wrapper<ProductVo> getById(@PathVariable Long id) {
        ProductVo productVo = mdcProductService.getProductVo(id);
        return WrapMapper.ok(productVo);
    }

    /**
     * 编辑商品
     *
     * @param mdcCategoryAddDto
     * @return
     */
    @PutMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wrapper saveCategory(@RequestBody MdcEditProductDto mdcCategoryAddDto) throws JsonProcessingException {
        logger.info("编辑商品. mdcCategoryAddDto={}", mdcCategoryAddDto);
        mdcProductService.saveProduct(mdcCategoryAddDto, getLoginAuthDto());
        return WrapMapper.ok();
    }

    /**
     * 删除商品信息
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deleteProductById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wrapper<ProductVo> deleteProductById(@PathVariable Long id) {
        logger.info("删除商品信息, id={}", id);
        mdcProductService.deleteProductById(id);
        return WrapMapper.ok();
    }

}
