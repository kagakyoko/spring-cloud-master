package com.pass.cloud.security.core.validate.social.weixin.connect;

import com.pass.cloud.security.core.validate.social.weixin.api.WeixinService;
import com.pass.cloud.security.core.validate.social.weixin.api.WeixinUserInfo;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * 微信 api适配器，将微信 api的数据模型转为spring social的标准模型
 *
 * @author takesi
 */
public class WeixinAdapter implements ApiAdapter<WeixinService> {

    private String openId;

    /**
     * Instantiates a new Weixin adapter.
     */
    public WeixinAdapter() {
    }

    /**
     * Instantiates a new Weixin adapter.
     *
     * @param openId the open id
     */
    public WeixinAdapter(String openId) {
        this.openId = openId;
    }

    /**
     * Test boolean.
     *
     * @param api the api
     * @return boolean boolean
     */
    @Override
    public boolean test(WeixinService api) {
        return true;
    }

    /**
     * Sets connection values.
     *
     * @param api    the api
     * @param values the values
     */
    @Override
    public void setConnectionValues(WeixinService api, ConnectionValues values) {
        WeixinUserInfo profile = api.getUserInfo(openId);
        values.setProviderUserId(profile.getOpenid());
        values.setDisplayName(profile.getNickname());
        values.setImageUrl(profile.getHeadimgurl());
    }

    /**
     * Fetch user profile user profile.
     *
     * @param api the api
     * @return user profile
     */
    @Override
    public UserProfile fetchUserProfile(WeixinService api) {
        return null;
    }

    /**
     * Update status.
     *
     * @param api     the api
     * @param message the message
     */
    @Override
    public void updateStatus(WeixinService api, String message) {
        //TODO do nothing
    }

}
