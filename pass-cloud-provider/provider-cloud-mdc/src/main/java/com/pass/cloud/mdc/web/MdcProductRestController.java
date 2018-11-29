package com.pass.cloud.mdc.web;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pass.cloud.core.support.BaseController;
import com.pass.cloud.mdc.model.domain.MdcProduct;
import com.pass.cloud.mdc.model.vo.ProductVo;
import com.pass.cloud.mdc.service.MdcProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author takesi
 */
@RestController
@RequestMapping(value = "/product")
@Api(value = "WEB - MdcProductRestController", tags = "MdcProductRestController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MdcProductRestController extends BaseController {

    @Autowired
    private MdcProductService mdcProductService;

    /**
     * 分页查询商品列表.
     *
     * @return the wrapper
     */
    @ApiOperation(httpMethod = "GET", value = "分页查询商品列表")
    @GetMapping(value = "/queryProductListWithPage", produces = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<ProductVo> queryProductListWithPage(@ApiParam(name = "page_num", value = "page_num", defaultValue = "1") @RequestParam(value = "page_num", defaultValue = "1") Integer pageNum, @ApiParam(name = "page_size", value = "page_size", defaultValue = "10") @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize, @ApiParam(name = "name", value = "商品名称") String name, @ApiParam(name = "status", value = "商品状态.1-在售 2-下架 3-删除") Integer status) {
        PageHelper.startPage(pageNum - 1, pageSize);
        MdcProduct mdcProduct = new MdcProduct();
        mdcProduct.setName(name);
        mdcProduct.setStatus(status);
        mdcProduct.setOrderBy("update_time desc");
        List<ProductVo> roleVoList = mdcProductService.queryProductListWithPage(mdcProduct);
        return new PageInfo<>(roleVoList);
    }

}
