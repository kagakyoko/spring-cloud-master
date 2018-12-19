package com.pass.cloud.opc.model.dto.oss;

import java.util.List;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class OptGetUrlRequest {

    /**
     * 附件ID
     */
    private Long attachmentId;

    /**
     * 超时时间
     */
    private Long expires;

    /**
     * 是否需要解密
     */
    private boolean encrypt;

    /**
     * 附件ID集合
     */
    private List<Long> attachmentIdList;

}
