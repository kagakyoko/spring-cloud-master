package com.pass.cloud.gateway.filter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.pass.cloud.base.enums.ErrorCodeEnum;
import com.pass.cloud.base.exception.BusinessException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.stereotype.Component;

/**
 * @author takesi
 */
@Component
public class RenewFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(RenewFilter.class);

    @Resource
    private JwtTokenStore jwtTokenStore;

    private static final int EXPIRES_IN = 60 * 20;

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        logger.info("RenewFilter - token续租...");
        RequestContext requestContext = RequestContext.getCurrentContext();
        try {
            doSomething(requestContext);
        } catch (Exception e) {
            logger.error("RenewFilter - token续租. [FAIL] EXCEPTION={}", e.getMessage(), e);
            throw new BusinessException(ErrorCodeEnum.UAC10011041);
        }
        return null;
    }

    private void doSomething(RequestContext requestContext) {
        HttpServletRequest request = requestContext.getRequest();
        String token = StringUtils.substringAfter(request.getHeader(HttpHeaders.AUTHORIZATION), "bearer ");
        if (StringUtils.isEmpty(token)) {
            return;
        }
        OAuth2AccessToken oAuth2AccessToken = jwtTokenStore.readAccessToken(token);
        int expiresIn = oAuth2AccessToken.getExpiresIn();

        if (expiresIn < EXPIRES_IN) {
            HttpServletResponse servletResponse = requestContext.getResponse();
            servletResponse.addHeader("Renew-Header", "true");
        }
    }

}
