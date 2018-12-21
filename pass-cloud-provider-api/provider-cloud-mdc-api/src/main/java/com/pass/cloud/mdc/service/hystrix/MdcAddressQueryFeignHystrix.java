package com.pass.cloud.mdc.service.hystrix;

import com.pass.cloud.mdc.model.dto.AddressDTO;
import com.pass.cloud.mdc.service.MdcAddressQueryFeignApi;

import com.pass.cloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;

/**
 * @author takesi
 */
@Component
public class MdcAddressQueryFeignHystrix implements MdcAddressQueryFeignApi {

    @Override
    public Wrapper<AddressDTO> getById(Long addressId) {
        return null;
    }

}
