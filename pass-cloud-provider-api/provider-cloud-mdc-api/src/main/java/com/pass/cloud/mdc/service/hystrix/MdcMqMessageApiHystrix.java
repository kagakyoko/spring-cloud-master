package com.pass.cloud.mdc.service.hystrix;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pass.cloud.base.dto.MessageQueryDto;
import com.pass.cloud.base.dto.MqMessageVo;
import com.pass.cloud.mdc.service.MdcMqMessageFeignApi;

import com.pass.cloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;

/**
 * @author takesi
 */
@Component
public class MdcMqMessageApiHystrix implements MdcMqMessageFeignApi {

    @Override
    public Wrapper<List<String>> queryMessageKeyList(List<String> messageKeyList) {
        return null;
    }

    @Override
    public Wrapper<PageInfo<MqMessageVo>> queryMessageListWithPage(MessageQueryDto messageQueryDto) {
        return null;
    }

}
