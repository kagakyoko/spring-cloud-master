package com.pass.cloud.security.core.properties;

import java.io.Serializable;

import lombok.Data;

/**
 * 验证码配置
 *
 * @author takesi
 */
@Data
public class ValidateCodeProperties implements Serializable {

    /**
     * 图片验证码配置
     */
    private ImageCodeProperties image = new ImageCodeProperties();

    /**
     * 短信验证码配置
     */
    private SmsCodeProperties sms = new SmsCodeProperties();

    /**
     * 邮箱验证码配置
     */
    private EmailCodeProperties email = new EmailCodeProperties();

}
