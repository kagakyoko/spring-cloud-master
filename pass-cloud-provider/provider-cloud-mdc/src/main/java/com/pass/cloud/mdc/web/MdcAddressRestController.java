package com.pass.cloud.mdc.web;

import java.util.List;

import com.pass.cloud.TreeNode;
import com.pass.cloud.core.support.BaseController;
import com.pass.cloud.mdc.model.domain.MdcAddress;
import com.pass.cloud.mdc.service.MdcAddressService;
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
@RequestMapping(value = "/address")
@Api(value = "WEB - MdcAddressRestController", tags = "MdcAddressRestController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MdcAddressRestController extends BaseController {

    @Autowired
    private MdcAddressService mdcAddressService;

    /**
     * Gets MdcAddress
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查看地址详情")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MdcAddress mdcAddress(@ApiParam(name = "id", value = "地址id", required = true) @PathVariable("id") Long id) {
        MdcAddress mdcAddress = mdcAddressService.getById(id);
        return mdcAddress;
    }

    /**
     * Gets MdcAddresses
     *
     * @param pid
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据父id查询地址列表")
    @GetMapping(value = "/list/{pid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MdcAddress> mdcAddresses(@ApiParam(name = "pid", value = "父id", required = true) @PathVariable("pid") Long pid) {
        List<MdcAddress> mdcAddresses = mdcAddressService.listByPid(pid);
        return mdcAddresses;
    }

    /**
     * Gets 4 city.
     *
     * @return the 4 city
     */
    @ApiOperation(httpMethod = "GET", value = "查看四级地址")
    @GetMapping(value = "/get4City", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TreeNode> get4City() {
        List<TreeNode> treeNodeList = mdcAddressService.get4City();
        return treeNodeList;
    }

}
