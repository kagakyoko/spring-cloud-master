package com.pass.cloud.security.core.validate.code.sms;

/**
 * @author takesi
 */
public interface SmsCodeSender {

    /**
     * Send.
     *
     * @param mobile the mobile
     * @param code   the code
     * @param ip     the ip
     */
    void send(String mobile, String code, String ip);

}
