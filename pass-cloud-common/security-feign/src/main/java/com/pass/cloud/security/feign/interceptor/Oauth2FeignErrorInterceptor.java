package com.pass.cloud.security.feign.interceptor;

import java.io.IOException;
import java.util.HashMap;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import com.pass.cloud.JacksonUtil;
import com.pass.cloud.base.enums.ErrorCodeEnum;
import com.pass.cloud.base.exception.BusinessException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

/**
 * @author takesi
 */
@Slf4j
public class Oauth2FeignErrorInterceptor implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    /**
     * Decode exception.
     *
     * @param methodKey the method key
     * @param response  the response
     * @return the exception
     */
    @Override
    public Exception decode(final String methodKey, final Response response) {
        if (response.status() >= HttpStatus.BAD_REQUEST.value() && response.status() < HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            return new HystrixBadRequestException("request exception wrapper");
        }

        try {
            HashMap map = JacksonUtil.OBJECT_MAPPER.readValue(response.body().asInputStream(), HashMap.class);
            Integer code = (Integer) map.get("code");
            String message = (String) map.get("message");
            if (code != null) {
                ErrorCodeEnum anEnum = ErrorCodeEnum.getEnum(code);
                if (anEnum != null) {
                    if (anEnum == ErrorCodeEnum.GL99990100) {
                        throw new IllegalArgumentException(message);
                    } else {
                        throw new BusinessException(anEnum);
                    }
                } else {
                    throw new BusinessException(ErrorCodeEnum.GL99990500, message);
                }
            }
        } catch (IOException e) {
            log.info("Failed to process response body");
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }

}
