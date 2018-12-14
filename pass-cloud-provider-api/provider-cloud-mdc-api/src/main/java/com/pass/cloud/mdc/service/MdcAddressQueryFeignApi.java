package com.pass.cloud.mdc.service;

import com.pass.cloud.mdc.model.dto.AddressDTO;

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
    AddressDTO getById(Long addressId);

}
