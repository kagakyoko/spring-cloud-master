package com.pass.cloud.security.core.validate.code.impl;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import com.pass.cloud.security.core.validate.code.ValidateCode;
import com.pass.cloud.security.core.validate.code.ValidateCodeException;
import com.pass.cloud.security.core.validate.code.ValidateCodeRepository;
import com.pass.cloud.security.core.validate.code.ValidateCodeType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 基于redis的验证码存取器，避免由于没有session导致无法存取验证码的问题
 *
 * @author takesi
 */
@Component
public class RedisValidateCodeRepository implements ValidateCodeRepository {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * Save.
     *
     * @param request the request
     * @param code    the code
     * @param type    the type
     */
    @Override
    public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType type) {
        String key = buildKey(request, type);
        redisTemplate.opsForValue().set(key, code, 3, TimeUnit.MINUTES);
    }

    /**
     * Get validate code.
     *
     * @param request the request
     * @param type    the type
     * @return the validate code
     */
    @Override
    public ValidateCode get(ServletWebRequest request, ValidateCodeType type) {
        Object value = redisTemplate.opsForValue().get(buildKey(request, type));
        if (value == null) {
            return null;
        }
        return (ValidateCode) value;
    }

    /**
     * Remove.
     *
     * @param request the request
     * @param type    the type
     */
    @Override
    public void remove(ServletWebRequest request, ValidateCodeType type) {
        redisTemplate.delete(buildKey(request, type));
    }

    private String buildKey(ServletWebRequest request, ValidateCodeType type) {
        String deviceId = request.getHeader("deviceId");
        if (StringUtils.isBlank(deviceId)) {
            throw new ValidateCodeException("请在请求头中携带deviceId参数");
        }
        return "code:" + type.toString().toLowerCase() + ":" + deviceId;
    }

}
