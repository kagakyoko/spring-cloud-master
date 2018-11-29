package com.pass.cloud.opc.model.dto.attachment;

import java.io.Serializable;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class OptUpdateAttachmentReqDto implements Serializable {

    private static final long serialVersionUID = -1727131719075160349L;

    /**
     * 附件流水号
     */
    private String serialNo;

    /**
     * 上传附件的相关业务流水号
     */
    private String refNo;

    private Long userId;

    private String userName;

}
