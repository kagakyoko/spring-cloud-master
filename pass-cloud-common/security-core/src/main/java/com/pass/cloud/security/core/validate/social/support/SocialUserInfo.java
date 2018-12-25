package com.pass.cloud.security.core.validate.social.support;

import java.io.Serializable;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class SocialUserInfo implements Serializable {

    private String providerId;

    private String providerUserId;

    private String nickname;

    private String headimg;

}
