package com.pass.cloud.security.core.properties;

import java.io.Serializable;

import lombok.Data;

/**
 * 认证服务器注册的第三方应用配置项
 *
 * @author takesi
 */
@Data
public class Oauth2ClientProperties implements Serializable {

    /**
     * 第三方应用appId
     */
    private String clientId;

    /**
     * 第三方应用appSecret
     */
    private String clientSecret;

    /**
     * 针对此应用发出的token的有效时间
     */
    private int accessTokenValidateSeconds = 7200;

    private int refreshTokenValiditySeconds = 2592000;

    private String scope;

}
