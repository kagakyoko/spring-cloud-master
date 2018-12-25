package com.pass.cloud.security.core.validate.social.weixin.connect;

import org.springframework.social.oauth2.AccessGrant;

/**
 * @author takesi
 */
public class WeixinAccessGrant extends AccessGrant {

    private static final long serialVersionUID = -7243374526633186782L;

    private String openId;

    /**
     * Instantiates a new Weixin access grant.
     */
    public WeixinAccessGrant() {
        super("");
    }

    /**
     * Instantiates a new Weixin access grant.
     *
     * @param accessToken  the access token
     * @param scope        the scope
     * @param refreshToken the refresh token
     * @param expiresIn    the expires in
     */
    public WeixinAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn) {
        super(accessToken, scope, refreshToken, expiresIn);
    }

    /**
     * Gets open id.
     *
     * @return the openId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * Sets open id.
     *
     * @param openId the openId to set
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

}
