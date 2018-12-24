package com.pass.cloud.security.core.properties;

import java.io.Serializable;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class Oauth2Properties implements Serializable {

    /**
     * 使用jwt时为token签名的秘钥
     */
    private String jwtSigningKey = "passcloud";

    /**
     * 客户端配置
     */
    private Oauth2ClientProperties[] clients = {};

}
