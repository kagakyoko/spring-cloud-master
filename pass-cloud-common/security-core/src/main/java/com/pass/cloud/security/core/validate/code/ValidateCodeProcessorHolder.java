package com.pass.cloud.security.core.validate.code;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 校验码处理器管理器
 *
 * @author takesi
 */
@Component
public class ValidateCodeProcessorHolder {

    private final Map<String, ValidateCodeProcessor> validateCodeProcessors;

    /**
     * Instantiates a new Validate code processor holder.
     *
     * @param validateCodeProcessors the validate code processors
     */
    @Autowired
    public ValidateCodeProcessorHolder(Map<String, ValidateCodeProcessor> validateCodeProcessors) {
        this.validateCodeProcessors = validateCodeProcessors;
    }

    /**
     * Find validate code processor validate code processor.
     *
     * @param type the type
     * @return validate code processor
     */
    ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
        return findValidateCodeProcessor(type.toString().toLowerCase());
    }

    /**
     * Find validate code processor validate code processor.
     *
     * @param type the type
     * @return validate code processor
     */
    private ValidateCodeProcessor findValidateCodeProcessor(String type) {
        String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
        ValidateCodeProcessor processor = validateCodeProcessors.get(name);
        if (processor == null) {
            throw new ValidateCodeException("验证码处理器" + name + "不存在");
        }
        return processor;
    }

}
