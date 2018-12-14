package com.pass.cloud.mdc.service.hystrix;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pass.cloud.base.dto.MessageQueryDto;
import com.pass.cloud.base.dto.MqMessageVo;
import com.pass.cloud.mdc.service.MdcMqMessageFeignApi;

import org.springframework.stereotype.Component;

/**
 * @author takesi
 */
@Component
public class MdcMqMessageApiHystrix implements MdcMqMessageFeignApi {

    @Override
    public List<String> queryMessageKeyList(List<String> messageKeyList) {
        return null;
    }

    @Override
    public PageInfo<MqMessageVo> queryMessageListWithPage(MessageQueryDto messageQueryDto) {
        return null;
    }

}
