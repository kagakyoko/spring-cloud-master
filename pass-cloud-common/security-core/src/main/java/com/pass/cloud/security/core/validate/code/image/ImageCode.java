package com.pass.cloud.security.core.validate.code.image;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

import com.pass.cloud.security.core.validate.code.ValidateCode;
import lombok.Data;

/**
 * 图片验证码
 *
 * @author takesi
 */
@Data
public class ImageCode extends ValidateCode {

    private static final long serialVersionUID = -6020470039852318468L;

    private BufferedImage image;

    /**
     * Instantiates a new Image code.
     *
     * @param image    the image
     * @param code     the code
     * @param expireIn the expire in
     */
    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }

    /**
     * Instantiates a new Image code.
     *
     * @param image      the image
     * @param code       the code
     * @param expireTime the expire time
     */
    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code, expireTime);
        this.image = image;
    }

}
