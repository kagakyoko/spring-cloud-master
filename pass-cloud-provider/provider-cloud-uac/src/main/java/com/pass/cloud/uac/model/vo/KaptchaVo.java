package com.pass.cloud.uac.model.vo;

import io.swagger.annotations.Api;
import lombok.Data;

/**
 * @author takesi
 */
@Api
@Data
public class KaptchaVo {

    private String cookieCode;

    private String base64Code;

    private String kaptchaCode;

}
