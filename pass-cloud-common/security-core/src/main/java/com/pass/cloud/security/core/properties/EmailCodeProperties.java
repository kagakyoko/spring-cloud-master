package com.pass.cloud.security.core.properties;

import java.io.Serializable;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class EmailCodeProperties implements Serializable {

    /**
     * 过期时间
     */
    private int expireIn = 60 * 60 * 24;

    /**
     * 要拦截的url，多个url用逗号隔开，ant pattern
     */
    private String url;

}
