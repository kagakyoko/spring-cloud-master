package com.pass.cloud.security.core.properties;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author takesi
 */
@ConfigurationProperties(prefix = "passcloud.security")
public class SecurityProperties implements Serializable {

    /**
     * 浏览器环境配置
     */
    private BrowserProperties browser = new BrowserProperties();

    /**
     * 验证码配置
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();

    /**
     * 社交登录配置
     */
    private SocialProperties social = new SocialProperties();

    /**
     * OAuth2认证服务器配置
     */
    private Oauth2Properties oauth2 = new Oauth2Properties();

}
