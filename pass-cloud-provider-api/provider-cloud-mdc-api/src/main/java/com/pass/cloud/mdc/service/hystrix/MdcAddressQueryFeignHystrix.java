package com.pass.cloud.mdc.service.hystrix;

import com.pass.cloud.mdc.model.dto.AddressDTO;
import com.pass.cloud.mdc.service.MdcAddressQueryFeignApi;

import org.springframework.stereotype.Component;

/**
 * @author takesi
 */
@Component
public class MdcAddressQueryFeignHystrix implements MdcAddressQueryFeignApi {

    @Override
    public AddressDTO getById(Long addressId) {
        return null;
    }

}
