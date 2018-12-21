package com.pass.cloud.mdc.web.rpc;

import com.pass.cloud.PublicUtil;
import com.pass.cloud.core.support.BaseController;
import com.pass.cloud.mdc.model.domain.MdcAddress;
import com.pass.cloud.mdc.model.dto.AddressDTO;
import com.pass.cloud.mdc.service.MdcAddressQueryFeignApi;
import com.pass.cloud.mdc.service.MdcAddressService;
import com.pass.cloud.wrapper.WrapMapper;
import com.pass.cloud.wrapper.Wrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author takesi
 */
@RestController
public class MdcAddressQueryFeignClient extends BaseController implements MdcAddressQueryFeignApi {

    @Autowired
    private MdcAddressService mdcAddressService;

    /**
     * 根据ID获取地址信息
     *
     * @param addressId
     * @return
     */
    @Override
    public Wrapper<AddressDTO> getById(@PathVariable("addressId") Long addressId) {
        logger.info("根据ID获取地址信息 addressId={}", addressId);
        AddressDTO addressDTO = null;
        MdcAddress mdcAddress = mdcAddressService.selectByKey(addressId);
        if (PublicUtil.isNotEmpty(mdcAddress)) {
            addressDTO = new AddressDTO();
            BeanUtils.copyProperties(mdcAddress, addressDTO);
        }
        return WrapMapper.ok(addressDTO);
    }

}
