package com.pass.cloud.uac.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.pass.cloud.PublicUtil;
import com.pass.cloud.base.dto.LoginAuthDto;
import com.pass.cloud.base.enums.ErrorCodeEnum;
import com.pass.cloud.core.support.BaseService;
import com.pass.cloud.uac.exception.UacBizException;
import com.pass.cloud.uac.mapper.UacUserMapper;
import com.pass.cloud.uac.model.domain.UacUser;
import com.pass.cloud.uac.model.dto.menu.UserMenuDto;
import com.pass.cloud.uac.model.dto.user.BindUserRolesDto;
import com.pass.cloud.uac.model.dto.user.ForgetResetPasswordDto;
import com.pass.cloud.uac.model.dto.user.LoginReqDto;
import com.pass.cloud.uac.model.dto.user.Perm;
import com.pass.cloud.uac.model.dto.user.ResetLoginPwdDto;
import com.pass.cloud.uac.model.dto.user.UserModifyPwdDto;
import com.pass.cloud.uac.model.dto.user.UserRegisterDto;
import com.pass.cloud.uac.model.dto.user.UserResetPwdDto;
import com.pass.cloud.uac.model.vo.UserBindRoleVo;
import com.pass.cloud.uac.service.UacUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

/**
 * @author takesi
 */
@Service
public class UacUserServiceImpl extends BaseService<UacUser> implements UacUserService {

    @Autowired
    private UacUserMapper uacUserMapper;

    @Override
    public UacUser findByLoginName(String loginName) {
        return uacUserMapper.findByLoginName(loginName);
    }

    @Override
    public UacUser findByMobileNo(String mobileNo) {
        return uacUserMapper.findByMobileNo(mobileNo);
    }

    @Override
    public void checkUserIsCorrect(LoginReqDto loginReqDto) {
        logger.info("用户【" + loginReqDto.getLoginName() + "】进行密码认证......");
        Map<String, String> loginNamePwdMap = Maps.newHashMap();
        loginNamePwdMap.put("loginName", loginReqDto.getLoginName());
        loginNamePwdMap.put("loginPwd", loginReqDto.getLoginPwd());
        UacUser uacUser = uacUserMapper.findByLoginNameAndLoginPwd(loginNamePwdMap);

        if (PublicUtil.isEmpty(uacUser)) {
            logger.info("用户【" + loginReqDto.getLoginName() + "】密码认证失败");
            throw new UacBizException(ErrorCodeEnum.UAC10011002, loginReqDto.getLoginName());
        }
        logger.info("用户【" + loginReqDto.getLoginName() + "】密码认证成功");
    }

    @Override
    public List<Perm> getAllPerms() {
        return null;
    }

    @Override
    public List<String> getUserPerms(Long userId) {
        return null;
    }

    @Override
    public int updateUser(UacUser uacUser) {
        return 0;
    }

    @Override
    public PageInfo queryUserListWithPage(UacUser uacUser) {
        return null;
    }

    @Override
    public int deleteUserById(Long userId) {
        return 0;
    }

    @Override
    public UacUser findUserInfoByUserId(Long userId) {
        return null;
    }

    @Override
    public void saveUacUser(UacUser user, LoginAuthDto loginAuthDto) {

    }

    @Override
    public int modifyUserStatusById(UacUser uacUser, LoginAuthDto loginAuthDto) {
        return 0;
    }

    @Override
    public void bindUserRoles(BindUserRolesDto bindUserRolesDto, LoginAuthDto loginAuthDto) {

    }

    @Override
    public List<UserMenuDto> queryUserMenuDtoData(LoginAuthDto loginAuthDto) {
        return null;
    }

    @Override
    public int bindUserMenus(List<Long> menuIdList, LoginAuthDto loginAuthDto) {
        return 0;
    }

    @Override
    public UacUser queryByUserId(Long userId) {
        return null;
    }

    @Override
    public int userModifyPwd(UserModifyPwdDto userModifyPwdDto, LoginAuthDto authResDto) {
        return 0;
    }

    @Override
    public int userResetPwd(UserResetPwdDto userResetPwdDto) {
        return 0;
    }

    @Override
    public void register(UserRegisterDto registerDto) {

    }

    @Override
    public boolean checkLoginName(String loginName) {
        return false;
    }

    @Override
    public boolean checkEmail(String loginName) {
        return false;
    }

    @Override
    public boolean checkMobileNo(String validValue) {
        return false;
    }

    @Override
    public int countUserByLoginNameAndEmail(String loginName, String email) {
        return 0;
    }

    @Override
    public int userEmailResetPwd(ForgetResetPasswordDto forgetResetPasswordDto) {
        return 0;
    }

    @Override
    public void modifyUserEmail(String email, String emailCode, LoginAuthDto loginAuthDto) {

    }

    @Override
    public void resetLoginPwd(Long userId, LoginAuthDto loginAuthDto) {

    }

    @Override
    public void resetLoginPwd(ResetLoginPwdDto resetLoginPwdDto) {

    }

    @Override
    public UserBindRoleVo getUserBindRoleDto(Long userId) {
        return null;
    }

    @Override
    public void activeUser(String activeUserToken) {

    }

    @Override
    public Collection<GrantedAuthority> loadUserAuthorities(Long userId) {
        return null;
    }

    @Override
    public UacUser findUserInfoByLoginName(String loginName) {
        return null;
    }
}
