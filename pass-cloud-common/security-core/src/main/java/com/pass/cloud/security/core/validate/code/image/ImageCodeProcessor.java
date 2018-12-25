package com.pass.cloud.security.core.validate.code.image;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import com.pass.cloud.JacksonUtil;
import com.pass.cloud.security.core.validate.code.ValidateCodeGenerator;
import com.pass.cloud.security.core.validate.code.ValidateCodeRepository;
import com.pass.cloud.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import com.pass.cloud.wrapper.WrapMapper;
import com.pass.cloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 图片验证码处理器
 *
 * @author takesi
 */
@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

    /**
     * Instantiates a new Abstract validate code processor.
     *
     * @param validateCodeGenerators the validate code generators
     * @param validateCodeRepository the validate code repository
     */
    public ImageCodeProcessor(Map<String, ValidateCodeGenerator> validateCodeGenerators, ValidateCodeRepository validateCodeRepository) {
        super(validateCodeGenerators, validateCodeRepository);
    }

    /**
     * 发送图形验证码，将其写到响应中
     *
     * @param request   the request
     * @param imageCode the image code
     * @throws Exception the exception
     */
    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(imageCode.getImage(), "JPEG", bos);

        Wrapper result = WrapMapper.ok(bos.toByteArray());

        String json = JacksonUtil.OBJECT_MAPPER.writeValueAsString(result);
        HttpServletResponse response = request.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

}
