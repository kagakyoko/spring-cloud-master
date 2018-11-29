package com.pass.cloud.base.exception;

import com.pass.cloud.base.enums.ErrorCodeEnum;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author takesi
 */
@Slf4j
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 3160241586346324994L;

    /**
     * 异常码
     */
    @Getter
    protected int code;

    public BusinessException() {
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
    }

    public BusinessException(ErrorCodeEnum codeEnum, Object... args) {
        super(String.format(codeEnum.msg(), args));
        this.code = codeEnum.code();
    }

}
