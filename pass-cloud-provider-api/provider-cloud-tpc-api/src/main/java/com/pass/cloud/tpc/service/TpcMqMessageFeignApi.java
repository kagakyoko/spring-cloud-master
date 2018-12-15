package com.pass.cloud.tpc.service;

import com.pass.cloud.tpc.model.dto.TpcMqMessageDto;
import com.pass.cloud.wrapper.Wrapper;

/**
 * @author takesi
 */
public interface TpcMqMessageFeignApi {

    /**
     * 预存储消息.
     *
     * @param mqMessageDto the mq message dto
     * @return the wrapper
     */
    Wrapper saveMessageWaitingConfirm(TpcMqMessageDto mqMessageDto);

    /**
     * 确认并发送消息.
     *
     * @param messageKey the message key
     * @return the wrapper
     */
    Wrapper confirmAndSendMessage(String messageKey);

    /**
     * 存储并发送消息.
     *
     * @param mqMessageDto the mq message dto
     * @return the wrapper
     */
    Wrapper saveAndSendMessage(TpcMqMessageDto mqMessageDto);

    /**
     * 直接发送消息.
     *
     * @param mqMessageDto the mq message dto
     * @return the wrapper
     */
    Wrapper directSendMessage(TpcMqMessageDto mqMessageDto);

    /**
     * 根据messageKey删除消息记录.
     *
     * @param messageKey the message key
     * @return the wrapper
     */
    Wrapper deleteMessageByMessageKey(String messageKey);

    /**
     * Confirm receive message wrapper.
     *
     * @param cid        the cid
     * @param messageKey the message key
     * @return the wrapper
     */
    Wrapper confirmReceiveMessage(final String cid, final String messageKey);

    /**
     * Save and confirm finish message wrapper.
     *
     * @param cid        the cid
     * @param messageKey the message key
     * @return the wrapper
     */
    Wrapper confirmConsumedMessage(final String cid, final String messageKey);

}
