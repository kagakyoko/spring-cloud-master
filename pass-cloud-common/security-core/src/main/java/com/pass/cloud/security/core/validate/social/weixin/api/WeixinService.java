package com.pass.cloud.security.core.validate.social.weixin.api;

/**
 * 微信API调用接口
 *
 * @author takesi
 */
public interface WeixinService {

    /**
     * Gets user info.
     *
     * @param openId the open id
     * @return the user info
     */
    WeixinUserInfo getUserInfo(String openId);

}
