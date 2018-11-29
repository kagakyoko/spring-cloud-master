package com.pass.cloud.opc.exceptions;

import com.pass.cloud.base.enums.ErrorCodeEnum;
import com.pass.cloud.base.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author takesi
 */
@Slf4j
public class OpcBizException extends BusinessException {

    private static final long serialVersionUID = -6552248511084911254L;

    /**
     * Instantiates a new Uac rpc exception.
     */
    public OpcBizException() {
    }

    /**
     * Instantiates a new Uac rpc exception.
     *
     * @param code      the code
     * @param msgFormat the msg format
     * @param args      the args
     */
    public OpcBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
        log.info("<== OpcBizException, code:{}, message:{}", this.code, super.getMessage());
    }

    /**
     * Instantiates a new Uac rpc exception.
     *
     * @param code the code
     * @param msg  the msg
     */
    public OpcBizException(int code, String msg) {
        super(code, msg);
        log.info("<== OpcBizException, code:{}, message:{}", this.code, super.getMessage());
    }

    /**
     * Instantiates a new Opc rpc exception.
     *
     * @param codeEnum the code enum
     */
    public OpcBizException(ErrorCodeEnum codeEnum) {
        super(codeEnum.code(), codeEnum.msg());
        log.info("<== OpcBizException, code:{}, message:{}", this.code, super.getMessage());
    }

    /**
     * Instantiates a new Opc rpc exception.
     *
     * @param codeEnum the code enum
     * @param args     the args
     */
    public OpcBizException(ErrorCodeEnum codeEnum, Object... args) {
        super(codeEnum, args);
        log.info("<== OpcBizException, code:{}, message:{}", this.code, super.getMessage());
    }

}
