package com.pass.cloud.opc.model.dto.oss;

import java.io.Serializable;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class OptUploadFileRespDto implements Serializable {

    private static final long serialVersionUID = -8008720269972450739L;

    /**
     * 附件ID
     */
    private Long attachmentId;

    /**
     * 文件完整url
     */
    private String attachmentUrl;

    /**
     * 文件名
     */
    private String attachmentName;

    /**
     * 文件路径(等于七牛文件名)
     */
    private String attachmentPath;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 关联业务单号
     */
    private String refNo;

}
