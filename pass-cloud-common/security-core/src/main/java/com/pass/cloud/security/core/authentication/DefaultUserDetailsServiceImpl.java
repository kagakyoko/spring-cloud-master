package com.pass.cloud.security.core.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 默认的 UserDetailsService 实现
 *
 * @author takesi
 */
public class DefaultUserDetailsServiceImpl implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(DefaultUserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.warn("请配置 UserDetailsService 接口的实现");
        throw new UsernameNotFoundException(username);
    }

}
