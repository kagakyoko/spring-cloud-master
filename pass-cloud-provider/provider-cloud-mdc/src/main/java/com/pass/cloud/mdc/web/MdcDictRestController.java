package com.pass.cloud.mdc.web;

import java.util.List;

import com.pass.cloud.core.support.BaseController;
import com.pass.cloud.mdc.model.vo.MdcDictVo;
import com.pass.cloud.mdc.service.MdcDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author takesi
 */
@RestController
@RequestMapping(value = "/dict")
@Api(value = "WEB - MdcDictRestController", tags = "MdcDictRestController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MdcDictRestController extends BaseController {

    @Autowired
    private MdcDictService mdcDictService;

    /**
     * 获取字典列表数据
     *
     * @return the wrapper
     */
    @ApiOperation(httpMethod = "GET", value = "获取字典树")
    @GetMapping(value = "/getTree", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MdcDictVo> queryDictTreeList() {
        List<MdcDictVo> dictVoList = mdcDictService.getDictTreeList();
        return dictVoList;
    }

    /**
     * 根据ID获取字典信息.
     *
     * @param id the id
     * @return the wrapper
     */

    @ApiOperation(httpMethod = "GET", value = "根据ID获取字典信息")
    @GetMapping(value = "/queryById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MdcDictVo queryDictVoById(@ApiParam(name = "id", value = "字典id", required = true) @PathVariable Long id) {
        MdcDictVo mdcDictVo = mdcDictService.getMdcDictVoById(id);
        return mdcDictVo;
    }

}
