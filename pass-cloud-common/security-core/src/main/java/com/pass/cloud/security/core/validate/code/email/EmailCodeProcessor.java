package com.pass.cloud.security.core.validate.code.email;

import java.util.Map;

import javax.annotation.Resource;

import com.pass.cloud.security.core.properties.SecurityConstants;
import com.pass.cloud.security.core.validate.code.ValidateCode;
import com.pass.cloud.security.core.validate.code.ValidateCodeGenerator;
import com.pass.cloud.security.core.validate.code.ValidateCodeRepository;
import com.pass.cloud.security.core.validate.code.impl.AbstractValidateCodeProcessor;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 短信验证码处理器
 *
 * @author takesi
 */
@Component("emailValidateCodeProcessor")
public class EmailCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

    /**
     * 短信验证码发送器
     */
    @Resource
    private EmailCodeSender emailCodeSender;

    /**
     * Instantiates a new Abstract validate code processor.
     *
     * @param validateCodeGenerators the validate code generators
     * @param validateCodeRepository the validate code repository
     */
    public EmailCodeProcessor(Map<String, ValidateCodeGenerator> validateCodeGenerators, ValidateCodeRepository validateCodeRepository) {
        super(validateCodeGenerators, validateCodeRepository);
    }

    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        String paramName = SecurityConstants.DEFAULT_PARAMETER_NAME_EMAIL;
        String email = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
        emailCodeSender.send(email, validateCode.getCode());
    }
}
