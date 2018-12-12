package com.pass.cloud.security.constant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pass.cloud.JacksonUtil;
import com.pass.cloud.wrapper.WrapMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * @author takesi
 */
public interface UacConstantHandler {

    /**
     * APP环境下认证成功处理器
     */
    SavedRequestAwareAuthenticationSuccessHandler SAVED_REQUEST_AWARE_AUTHENTICATION_SUCCESS_HANDLER = new SavedRequestAwareAuthenticationSuccessHandler() {
        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    };

    /**
     * 默认的退出成功处理器，如果设置了passcloud.security.browser.signOutUrl，则跳到配置的地址上，
     * 如果没配置，则返回json格式的响应
     */
    LogoutSuccessHandler LOGOUT_SUCCESS_HANDLER = (request, response, authentication) -> {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write(JacksonUtil.OBJECT_MAPPER.writeValueAsString(WrapMapper.ok("退出成功")));
    };

}
