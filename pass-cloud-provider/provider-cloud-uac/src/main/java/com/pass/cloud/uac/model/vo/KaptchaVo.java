package com.pass.cloud.uac.model.vo;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class KaptchaVo {

    private String cookieCode;

    private String base64Code;

    private String kaptchaCode;

}
