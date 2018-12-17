package com.pass.cloud.mdc.web.frontend;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pass.cloud.core.support.BaseController;
import com.pass.cloud.mdc.model.domain.MdcProduct;
import com.pass.cloud.mdc.model.vo.ProductVo;
import com.pass.cloud.mdc.service.MdcProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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

}
