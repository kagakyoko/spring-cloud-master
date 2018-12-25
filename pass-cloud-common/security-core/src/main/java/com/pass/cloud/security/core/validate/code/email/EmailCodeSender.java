package com.pass.cloud.security.core.validate.code.email;

/**
 * @author takesi
 */
public interface EmailCodeSender {

    /**
     * Send.
     *
     * @param email the email
     * @param code  the code
     */
    void send(String email, String code);

}
