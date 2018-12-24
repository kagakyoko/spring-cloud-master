package com.pass.cloud.security.core.properties;

import java.io.Serializable;

import lombok.Data;

/**
 * QQ登录配置项
 *
 * @author takesi
 */
@Data
public class QqProperties implements Serializable {

    /**
     * 第三方id，用来决定发起第三方登录的url，默认是 qq。
     */
    private String providerId = "qq";

}
