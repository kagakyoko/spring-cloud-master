package com.pass.cloud.uac.web;

import com.pass.cloud.base.enums.ErrorCodeEnum;
import com.pass.cloud.base.exception.BusinessException;
import com.pass.cloud.wrapper.WrapMapper;
import com.pass.cloud.wrapper.Wrapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局的的异常拦截器.
 *
 * @author takesi
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

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
     * 无权限访问.
     *
     * @param e the e
     * @return the wrapper
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AccessDeniedException.class)
    public Wrapper unAuthorizedException(AccessDeniedException e) {
        log.error("业务异常={}", e.getMessage(), e);
        return WrapMapper.wrap(ErrorCodeEnum.GL99990401.code(), ErrorCodeEnum.GL99990401.msg());
    }

}
