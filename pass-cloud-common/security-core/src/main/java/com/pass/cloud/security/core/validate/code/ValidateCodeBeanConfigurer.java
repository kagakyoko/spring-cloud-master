package com.pass.cloud.security.core.validate.code;

import com.google.code.kaptcha.Producer;
import com.pass.cloud.security.core.properties.SecurityProperties;
import com.pass.cloud.security.core.validate.code.image.ImageCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 验证码相关的扩展点配置。配置在这里的bean，业务系统都可以通过声明同类型或同名的bean来覆盖安全
 * 模块默认的配置
 *
 * @author takesi
 */
@Configuration
public class ValidateCodeBeanConfigurer {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private Producer captchaProducer;

    /**
     * 图片验证码图片生成器
     *
     * @return validate code generator
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
    public ValidateCodeGenerator imageValidateCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        codeGenerator.setCaptchaProducer(captchaProducer);
        return codeGenerator;
    }

}