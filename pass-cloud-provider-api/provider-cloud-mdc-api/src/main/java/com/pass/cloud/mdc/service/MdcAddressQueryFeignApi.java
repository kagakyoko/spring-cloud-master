package com.pass.cloud.mdc.service;

import com.pass.cloud.mdc.model.dto.AddressDTO;
import com.pass.cloud.wrapper.Wrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author takesi
 */
public interface MdcAddressQueryFeignApi {

    /**
     * Select by id
     *
     * @param addressId
     * @return
     */
    @GetMapping(value = "/api/address/getById/{addressId}")
    Wrapper<AddressDTO> getById(@PathVariable("addressId") Long addressId);

}
