package com.pass.cloud.mdc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pass.cloud.base.dto.MessageQueryDto;
import com.pass.cloud.base.dto.MqMessageVo;

/**
 * @author takesi
 */
public interface MdcMqMessageFeignApi {

    /**
     * Query waiting confirm message list wrapper.
     *
     * @param messageKeyList the message key list
     * @return the wrapper
     */
    List<String> queryMessageKeyList(List<String> messageKeyList);

    /**
     * Query message list with page wrapper.
     *
     * @param messageQueryDto the message query dto
     * @return the wrapper
     */
    PageInfo<MqMessageVo> queryMessageListWithPage(MessageQueryDto messageQueryDto);

}
