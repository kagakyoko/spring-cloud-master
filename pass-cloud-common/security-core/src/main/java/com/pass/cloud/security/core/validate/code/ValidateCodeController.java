package com.pass.cloud.security.core.validate.code;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pass.cloud.security.core.properties.SecurityConstants;
import com.pass.cloud.wrapper.WrapMapper;
import com.pass.cloud.wrapper.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 生成校验码的请求处理器
 *
 * @author takesi
 */
@RestController
public class ValidateCodeController {

    private static Logger logger = LoggerFactory.getLogger(ValidateCodeController.class);

    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;

    /**
     * 创建验证码，根据验证码类型不同，调用不同的 {@link ValidateCodeProcessor}接口实现
     *
     * @param request  the request
     * @param response the response
     * @param type     the type
     * @throws Exception the exception
     */
    @PostMapping(SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/{type}")
    public void createCode(@PathVariable String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
        validateCodeProcessorHolder.findValidateCodeProcessor(ValidateCodeType.getCodeType(type))
                .create(new ServletWebRequest(request, response));
    }

    /**
     * Check code object.
     *
     * @param request  the request
     * @param response the response
     * @param type     the type
     * @return the object
     */
    @GetMapping(SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/{type}")
    public Object checkCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) {
        Wrapper result = WrapMapper.ok("校验成功");
        try {
            validateCodeProcessorHolder.findValidateCodeProcessor(ValidateCodeType.getCodeType(type))
                    .check(new ServletWebRequest(request, response));
        } catch (ValidateCodeException e) {
            result = WrapMapper.error(e.getMessage());
        } catch (Exception e) {
            logger.error("getAccessToken={}", e.getMessage(), e);
            result = WrapMapper.error("验证码错误");
        }
        return result;
    }

}
