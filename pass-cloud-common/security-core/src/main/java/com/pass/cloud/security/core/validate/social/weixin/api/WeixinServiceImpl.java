package com.pass.cloud.security.core.validate.social.weixin.api;

import java.nio.charset.Charset;
import java.util.List;

import com.pass.cloud.JacksonUtil;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

/**
 * Weixin API调用模板， scope为Request的Spring bean, 根据当前用户的accessToken创建
 *
 * @author takesi
 */
@Slf4j
public class WeixinServiceImpl extends AbstractOAuth2ApiBinding implements WeixinService {

    private static final String ERR_CODE = "errcode";

    /**
     * 获取用户信息的url
     */
    private static final String URL_GET_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?openid=";

    /**
     * Instantiates a new Weixin.
     *
     * @param accessToken the access token
     */
    public WeixinServiceImpl(String accessToken) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
    }

    /**
     * 默认注册的StringHttpMessageConverter字符集为ISO-8859-1，而微信返回的是UTF-8的，所以覆盖了原来的方法。
     *
     * @return the message converters
     */
    @Override
    protected List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> messageConverters = super.getMessageConverters();
        messageConverters.remove(0);
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return messageConverters;
    }

    /**
     * 获取微信用户信息
     *
     * @param openId the open id
     * @return
     */
    @Override
    public WeixinUserInfo getUserInfo(String openId) {
        String url = URL_GET_USER_INFO + openId;
        String response = getRestTemplate().getForObject(url, String.class);
        if (StringUtils.contains(response, ERR_CODE)) {
            return null;
        }
        WeixinUserInfo profile = null;
        try {
            profile = JacksonUtil.OBJECT_MAPPER.readValue(response, WeixinUserInfo.class);
        } catch (Exception e) {
            log.error("getUserInfo={}", e.getMessage(), e);
        }
        return profile;
    }
}
