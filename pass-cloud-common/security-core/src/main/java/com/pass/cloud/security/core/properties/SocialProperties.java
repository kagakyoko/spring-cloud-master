package com.pass.cloud.security.core.properties;

import java.io.Serializable;

import lombok.Data;

/**
 * 社交登录配置项
 *
 * @author takesi
 */
@Data
public class SocialProperties implements Serializable {

    /**
     * 社交登录功能拦截的url
     */
    private String filterProcessesUrl = "/auth";

    private QqProperties qq = new QqProperties();

    private WeiChatProperties weixin = new WeiChatProperties();

}
