package com.pass.cloud.opc.model.dto.attachment;

import java.io.Serializable;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class OptAttachmentQueryReqDto implements Serializable {

    private static final long serialVersionUID = 4781783608243094328L;

    private Long id;

    /**
     * 附件流水号
     */
    private String serialNo;

    /**
     * 上传附件的相关业务流水号
     */
    private String refNo;

}
