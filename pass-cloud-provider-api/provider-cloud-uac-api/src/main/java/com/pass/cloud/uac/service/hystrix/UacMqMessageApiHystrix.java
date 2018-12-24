package com.pass.cloud.uac.service.hystrix;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pass.cloud.base.dto.MessageQueryDto;
import com.pass.cloud.base.dto.MqMessageVo;
import com.pass.cloud.uac.service.UacMqMessageFeignApi;
import com.pass.cloud.wrapper.Wrapper;

import org.springframework.stereotype.Component;

/**
 * @author takesi
 */
@Component
public class UacMqMessageApiHystrix implements UacMqMessageFeignApi {

    @Override
    public Wrapper<List<String>> queryMessageKeyList(List<String> messageKeyList) {
        return null;
    }

    @Override
    public Wrapper<PageInfo<MqMessageVo>> queryMessageListWithPage(MessageQueryDto messageQueryDto) {
        return null;
    }

}
