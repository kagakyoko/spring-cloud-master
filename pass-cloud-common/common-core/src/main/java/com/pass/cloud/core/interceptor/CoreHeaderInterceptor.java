package com.pass.cloud.core.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author takesi
 */
@Slf4j
public class CoreHeaderInterceptor extends HandlerInterceptorAdapter {

    /**
     * The constant HEADER_LABEL.
     */
    public static final String HEADER_LABEL = "x-label";
    /**
     * The constant HEADER_LABEL_SPLIT.
     */
    public static final String HEADER_LABEL_SPLIT = ",";

}
