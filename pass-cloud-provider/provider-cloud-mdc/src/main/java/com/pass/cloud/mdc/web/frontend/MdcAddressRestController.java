package com.pass.cloud.mdc.web.frontend;

import java.util.List;

import com.pass.cloud.TreeNode;
import com.pass.cloud.core.support.BaseController;
import com.pass.cloud.mdc.model.domain.MdcAddress;
import com.pass.cloud.mdc.service.MdcAddressService;
import com.pass.cloud.wrapper.WrapMapper;
import com.pass.cloud.wrapper.Wrapper;
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
public class MdcAddressRestController extends BaseController {

    @Autowired
    private MdcAddressService mdcAddressService;

    /**
     * Gets MdcAddress
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wrapper<MdcAddress> mdcAddress(@PathVariable("id") Long id) {
        MdcAddress mdcAddress = mdcAddressService.getById(id);
        return WrapMapper.ok(mdcAddress);
    }

    /**
     * Gets MdcAddresses
     *
     * @param pid
     * @return
     */
    @GetMapping(value = "/list/{pid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wrapper<List> mdcAddresses(@PathVariable("pid") Long pid) {
        List<MdcAddress> mdcAddresses = mdcAddressService.listByPid(pid);
        return WrapMapper.ok(mdcAddresses);
    }

    /**
     * Gets 4 city.
     *
     * @return the 4 city
     */
    @GetMapping(value = "/get4City", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wrapper<List> get4City() {
        List<TreeNode> treeNodeList = mdcAddressService.get4City();
        return WrapMapper.ok(treeNodeList);
    }

}
