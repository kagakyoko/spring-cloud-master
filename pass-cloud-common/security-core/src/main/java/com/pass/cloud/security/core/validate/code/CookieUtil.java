package com.pass.cloud.security.core.validate.code;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author takesi
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CookieUtil {

    private static Logger logger = LoggerFactory.getLogger(CookieUtil.class);

    /**
     * 设置cookie域，默认为：passcloud.net]
     */
    private final static String COOKIE_DOMAIN = "passcloud.net";

    /**
     * 设置默认路径：/，这个路径即该工程下都可以访问该cookie 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
     */
    private final static String COOKIE_PATH = "/";

    /**
     * 设置cookie有效期，根据需要自定义[本系统设置为7天]
     */
    private final static int COOKIE_MAX_AGE = 60 * 60 * 24 * 7;

}
