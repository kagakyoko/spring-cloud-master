package com.pass.cloud.mdc.web;

import com.pass.cloud.base.enums.ErrorCodeEnum;
import com.pass.cloud.base.exception.BusinessException;
import com.pass.cloud.mdc.model.dto.GlobalExceptionLogDto;
import com.pass.cloud.mdc.service.MdcExceptionLogFeignApi;
import com.pass.cloud.wrapper.WrapMapper;
import com.pass.cloud.wrapper.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author takesi
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    @Qualifier(value = "taskExecutor")
    private TaskExecutor taskExecutor;

    @Autowired
    private MdcExceptionLogFeignApi mdcExceptionLogFeignApi;

    /**
     * 参数非法异常.
     *
     * @param e the e
     * @return the wrapper
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public Wrapper illegalArgumentException(IllegalArgumentException e) {
        log.error("参数非法异常={}", e.getMessage(), e);
        return WrapMapper.wrap(ErrorCodeEnum.GL99990100.code(), e.getMessage());
    }

    /**
     * 业务异常.
     *
     * @param e the e
     * @return the wrapper
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BusinessException.class)
    public Wrapper businessException(BusinessException e) {
        log.error("业务异常={}", e.getMessage(), e);
        return WrapMapper.wrap(e.getCode() == 0 ? Wrapper.ERROR_CODE : e.getCode(), e.getMessage());
    }

    /**
     * 全局异常.
     *
     * @param e the e
     * @return the wrapper
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Wrapper exception(Exception e, @Value("${spring.profiles.active}") String profile, @Value("${spring.application.name}") String applicationName) {
        log.info("保存全局异常信息 ex={}", e.getMessage(), e);
        taskExecutor.execute(() -> {
            GlobalExceptionLogDto globalExceptionLogDto = new GlobalExceptionLogDto().getGlobalExceptionLogDto(e, profile, applicationName);
            mdcExceptionLogFeignApi.saveAndSendExceptionLog(globalExceptionLogDto);
        });
        return WrapMapper.error();
    }

}
