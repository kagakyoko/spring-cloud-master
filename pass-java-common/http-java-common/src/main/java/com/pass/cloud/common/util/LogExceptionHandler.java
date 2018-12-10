package com.pass.cloud.common.util;

import com.pass.cloud.common.api.HttpErrorExceptionHandler;
import com.pass.cloud.common.error.HttpErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author takesi
 */
public class LogExceptionHandler implements HttpErrorExceptionHandler {

    private Logger log = LoggerFactory.getLogger(HttpErrorExceptionHandler.class);

    @Override
    public void handle(HttpErrorException e) {

        this.log.error("Error happens", e);

    }

}
