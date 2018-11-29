package com.pass.cloud.opc.model.dto.oss;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@AllArgsConstructor
public class ElementImgUrlDto implements Serializable {

    private static final long serialVersionUID = -5800852605728871320L;

    /**
     * 图片完整地址
     */
    private String url;
    /**
     * 图片名称
     */
    private String name;
    /**
     * 图片关联的附件ID
     */
    private Long attachmentId;

    public ElementImgUrlDto() {
        super();
    }

}
