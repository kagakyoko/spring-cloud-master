package com.pass.cloud.mdc.web.rpc;

import com.pass.cloud.core.support.BaseController;
import com.pass.cloud.mdc.model.dto.GlobalExceptionLogDto;
import com.pass.cloud.mdc.service.MdcExceptionLogFeignApi;
import com.pass.cloud.wrapper.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author takesi
 */
@Slf4j
@RefreshScope
@RestController
public class MdcExceptionLogFeignClient extends BaseController implements MdcExceptionLogFeignApi {

    /**
     * 保存日志并发送钉钉消息
     *
     * @param exceptionLogDto
     * @return
     */
    @Override
    public Wrapper saveAndSendExceptionLog(@RequestBody GlobalExceptionLogDto exceptionLogDto) {
        return null;
    }

}
