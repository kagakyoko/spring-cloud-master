package com.pass.cloud.security.core.domain;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author takesi
 */
@Setter
public class SecurityUser implements UserDetails {

    private static final long serialVersionUID = 4872628781561412463L;

    private static final String ENABLE = "ENABLE";

    private Collection<GrantedAuthority> authorities;

    @Getter
    private Long userId;

    @Getter
    private String nickName;

    private String loginName;

    private String loginPwd;

    private String status;

    @Getter
    private Long groupId;

    @Getter
    private String groupName;

    public SecurityUser(Long userId, String loginName, String loginPwd, String nickName, Long groupId, String groupName) {
        this.setUserId(userId);
        this.setLoginName(loginName);
        this.setLoginPwd(loginPwd);
        this.setNickName(nickName);
        this.setGroupId(groupId);
        this.setGroupName(groupName);
    }

    public SecurityUser(Long userId, String loginName, String loginPwd, String nickName, Long groupId, String groupName, String status, Collection<GrantedAuthority> grantedAuthorities) {
        this.setUserId(userId);
        this.setLoginName(loginName);
        this.setLoginPwd(loginPwd);
        this.setNickName(nickName);
        this.setGroupId(groupId);
        this.setGroupName(groupName);
        this.setStatus(status);
        this.authorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.loginPwd;
    }

    @Override
    public String getUsername() {
        return this.loginName;
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
