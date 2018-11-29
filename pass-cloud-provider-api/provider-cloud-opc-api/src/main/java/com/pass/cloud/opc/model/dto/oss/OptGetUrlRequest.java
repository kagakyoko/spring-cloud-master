package com.pass.cloud.opc.model.dto.oss;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@ApiModel
public class OptGetUrlRequest {

    @ApiModelProperty(value = "附件ID")
    private Long attachmentId;

    @ApiModelProperty(value = "超时时间")
    private Long expires;

    @ApiModelProperty(value = "是否需要解密")
    private boolean encrypt;

    @ApiModelProperty(value = "附件ID集合")
    private List<Long> attachmentIdList;

}
