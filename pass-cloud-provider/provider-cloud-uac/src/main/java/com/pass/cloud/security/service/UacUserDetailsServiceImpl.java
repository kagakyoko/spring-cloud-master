package com.pass.cloud.security.service;

import java.util.Collection;

import com.pass.cloud.security.core.domain.SecurityUser;
import com.pass.cloud.uac.model.domain.UacUser;
import com.pass.cloud.uac.service.UacUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author takesi
 */
public class UacUserDetailsServiceImpl implements UserDetailsService {

    private final UacUserService uacUserService;

    @Autowired
    public UacUserDetailsServiceImpl(final UacUserService uacUserService) {
        this.uacUserService = uacUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> grantedAuthorities;
        UacUser user = uacUserService.findByLoginName(username);

        if (user == null) {
            throw new BadCredentialsException("用户名不存在或者密码错误");
        }
        user = uacUserService.findUserInfoByUserId(user.getId());
        grantedAuthorities = uacUserService.loadUserAuthorities(user.getId());
        return new SecurityUser(user.getId(), user.getLoginName(), user.getLoginPwd(),
                user.getUserName(), user.getGroupId(), user.getGroupName(), user.getStatus(), grantedAuthorities);
    }
}
