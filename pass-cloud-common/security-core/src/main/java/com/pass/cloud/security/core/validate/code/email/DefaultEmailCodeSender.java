package com.pass.cloud.security.core.validate.code.email;

import lombok.extern.slf4j.Slf4j;

/**
 * 默认的短信验证码发送器
 *
 * @author takesi
 */
@Slf4j
public class DefaultEmailCodeSender implements EmailCodeSender {

    @Override
    public void send(String email, String code) {
        log.warn("请配置真实的邮件验证码发送器(SmsCodeSender)");
        log.info("向邮件" + email + "发送短信验证码" + code);
    }

}
