package com.pass.cloud.security.core.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 图片验证码配置项
 *
 * @author takesi
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ImageCodeProperties extends SmsCodeProperties {

    /**
     * Instantiates a new Image code properties.
     */
    public ImageCodeProperties() {
        super.setLength(4);
    }

}
