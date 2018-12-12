package com.pass.cloud.security.domain;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author takesi
 */
@Setter
public class SecurityUser implements UserDetails {

    private static final long serialVersionUID = 4872628781561412463L;

    private static final String ENABLE = "ENABLE";

    @Getter
    private Long userId;

    @Getter
    private String nickName;

    @Getter
    private String loginName;

    @Getter
    private String loginPwd;

    private String status;

    @Getter
    private Long groupId;

    @Getter
    private String groupName;

    @Getter
    private Collection<GrantedAuthority> authorities;

    public SecurityUser(Long userId, String loginName, String loginPwd, String nickName, Long groupId, String groupName) {
        this.userId = userId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.nickName = nickName;
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public SecurityUser(Long userId, String loginName, String loginPwd, String nickName, Long groupId, String groupName, String status, Collection<GrantedAuthority> grantedAuthorities) {
        this.userId = userId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.nickName = nickName;
        this.groupId = groupId;
        this.groupName = groupName;
        this.status = status;
        this.authorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.getLoginPwd();
    }

    @Override
    public String getUsername() {
        return this.getLoginName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return StringUtils.equals(this.status, ENABLE);
    }

}
