package com.pass.cloud.security.core.validate.code.image;

import java.awt.image.BufferedImage;

import com.google.code.kaptcha.Producer;
import com.pass.cloud.security.core.properties.SecurityProperties;
import com.pass.cloud.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 默认的图片验证码生成器
 *
 * @author takesi
 */
public class ImageCodeGenerator implements ValidateCodeGenerator {

    private SecurityProperties securityProperties;

    private Producer captchaProducer;

    /**
     * 生成图片验证码.
     *
     * @param request the request
     * @return the image code
     */
    @Override
    public ImageCode generate(ServletWebRequest request) {
        String kaptchaCode = captchaProducer.createText();
        BufferedImage image = captchaProducer.createImage(kaptchaCode);
        return new ImageCode(image, kaptchaCode, securityProperties.getCode().getImage().getExpireIn());
    }

    /**
     * Sets security properties.
     *
     * @param securityProperties the security properties
     */
    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    /**
     * Sets captcha producer.
     *
     * @param captchaProducer the captcha producer
     */
    public void setCaptchaProducer(Producer captchaProducer) {
        this.captchaProducer = captchaProducer;
    }

}
