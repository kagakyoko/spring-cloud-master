package com.pass.cloud.uac.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pass.cloud.base.dto.MessageQueryDto;
import com.pass.cloud.base.dto.MqMessageVo;
import com.pass.cloud.security.feign.Oauth2FeignAutoConfiguration;
import com.pass.cloud.uac.service.hystrix.UacMqMessageApiHystrix;
import com.pass.cloud.wrapper.Wrapper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author takesi
 */
@FeignClient(value = "passcloud-provider-uac", configuration = Oauth2FeignAutoConfiguration.class, fallback = UacMqMessageApiHystrix.class)
public interface UacMqMessageFeignApi {

    /**
     * Query waiting confirm message list wrapper.
     *
     * @param messageKeyList the message key list
     * @return the wrapper
     */
    @GetMapping(value = "/api/uac/message/queryMessageKeyList")
    Wrapper<List<String>> queryMessageKeyList(List<String> messageKeyList);

    /**
     * Query message list with page wrapper.
     *
     * @param messageQueryDto the message query dto
     * @return the wrapper
     */
    @GetMapping(value = "/api/uac/message/queryMessageListWithPage")
    Wrapper<PageInfo<MqMessageVo>> queryMessageListWithPage(MessageQueryDto messageQueryDto);

}
