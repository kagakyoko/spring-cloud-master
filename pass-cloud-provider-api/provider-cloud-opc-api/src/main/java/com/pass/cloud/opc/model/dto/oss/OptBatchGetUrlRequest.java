package com.pass.cloud.opc.model.dto.oss;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@ApiModel
public class OptBatchGetUrlRequest {

    @ApiModelProperty(value = "文件流水号")
    private String refNo;

    @ApiModelProperty(value = "超时时间")
    private Long expires;

    @ApiModelProperty(value = "是否需要解密")
    private boolean encrypt;

    public OptBatchGetUrlRequest(String refNo) {
        this.refNo = refNo;
    }

}
