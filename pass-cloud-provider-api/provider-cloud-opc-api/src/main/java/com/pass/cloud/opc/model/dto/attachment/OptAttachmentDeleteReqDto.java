package com.pass.cloud.opc.model.dto.attachment;

import java.io.Serializable;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class OptAttachmentDeleteReqDto implements Serializable {

    private static final long serialVersionUID = 731160897713227519L;

    private String[] serialNos;

}
