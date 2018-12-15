package com.pass.cloud.tpc.service.hystrix;

import com.pass.cloud.tpc.model.dto.TpcMqMessageDto;
import com.pass.cloud.tpc.service.TpcMqMessageFeignApi;
import com.pass.cloud.wrapper.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author takesi
 */
@Slf4j
@Component
public class TpcMqMessageFeignApiHystrix implements TpcMqMessageFeignApi {

    @Override
    public Wrapper saveMessageWaitingConfirm(TpcMqMessageDto mqMessageDto) {
        return null;
    }

    @Override
    public Wrapper confirmAndSendMessage(String messageKey) {
        return null;
    }

    @Override
    public Wrapper saveAndSendMessage(TpcMqMessageDto mqMessageDto) {
        return null;
    }

    @Override
    public Wrapper directSendMessage(TpcMqMessageDto mqMessageDto) {
        return null;
    }

    @Override
    public Wrapper deleteMessageByMessageKey(String messageKey) {
        return null;
    }

    @Override
    public Wrapper confirmReceiveMessage(String cid, String messageKey) {
        return null;
    }

    @Override
    public Wrapper confirmConsumedMessage(String cid, String messageKey) {
        return null;
    }

}
