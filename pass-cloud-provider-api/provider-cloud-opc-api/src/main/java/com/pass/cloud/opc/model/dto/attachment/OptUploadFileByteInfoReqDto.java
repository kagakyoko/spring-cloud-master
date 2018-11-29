package com.pass.cloud.opc.model.dto.attachment;

import java.io.Serializable;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class OptUploadFileByteInfoReqDto implements Serializable {

    private static final long serialVersionUID = 4695223041316258658L;

    /**
     * 文件字节码
     */
    private byte[] fileByteArray;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件类型
     */
    private String fileType;

}
