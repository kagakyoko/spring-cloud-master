package com.pass.cloud.uac.service.hystrix;

import com.pass.cloud.uac.service.UacUserTokenFeignApi;
import com.pass.cloud.wrapper.Wrapper;

import org.springframework.stereotype.Component;

/**
 * @author takesi
 */
@Component
public class UacUserTokenFeignApiHystrix implements UacUserTokenFeignApi {

    @Override
    public Wrapper<Integer> updateTokenOffLine() {
        return null;
    }

}
