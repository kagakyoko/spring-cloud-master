package com.pass.cloud.security.core.properties;

import java.io.Serializable;

import lombok.Data;

/**
 * 微信登录配置项
 *
 * @author takesi
 */
@Data
public class WeiChatProperties implements Serializable {

    /**
     * 第三方id，用来决定发起第三方登录的url，默认是 weixin。
     */
    private String providerId = "weixin";

}
