package com.pass.cloud.security.feign.properties;

import java.io.Serializable;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author takesi
 */
@Getter
@ConfigurationProperties(prefix = "passcloud.oauth2.client")
public class Oauth2ClientProperties implements Serializable {

    private static final long serialVersionUID = 3319698607712846427L;

    private String id;

    private String accessTokenUrl;

    private String clientId;

    private String clientSecret;

    private String clientAuthenticationScheme;

    public void setId(String id) {
        this.id = id;
    }

    public void setAccessTokenUrl(String accessTokenUrl) {
        this.accessTokenUrl = accessTokenUrl;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setClientAuthenticationScheme(String clientAuthenticationScheme) {
        this.clientAuthenticationScheme = clientAuthenticationScheme;
    }

}
