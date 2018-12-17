package com.pass.cloud.opc.model.dto.oss;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class OptBatchGetUrlRequest {

    /**
     * 文件流水号
     */
    private String refNo;

    /**
     * 超时时间
     */
    private Long expires;

    /**
     * 是否需要解密
     */
    private boolean encrypt;

    public OptBatchGetUrlRequest(String refNo) {
        this.refNo = refNo;
    }

}
