package com.pass.cloud.common.api;

import com.pass.cloud.common.error.HttpErrorException;

/**
 * WxErrorException处理器.
 *
 * @author takesi
 */
public interface HttpErrorExceptionHandler {

    /**
     * handle
     *
     * @param e
     */
    void handle(HttpErrorException e);

}
