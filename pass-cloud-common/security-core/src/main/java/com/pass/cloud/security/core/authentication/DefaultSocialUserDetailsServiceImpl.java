package com.pass.cloud.security.core.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;

/**
 * @author takesi
 */
public class DefaultSocialUserDetailsServiceImpl implements SocialUserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(DefaultSocialUserDetailsServiceImpl.class);

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        logger.warn("请配置 SocialUserDetailsService 接口的实现");
        throw new UsernameNotFoundException(userId);
    }

}
