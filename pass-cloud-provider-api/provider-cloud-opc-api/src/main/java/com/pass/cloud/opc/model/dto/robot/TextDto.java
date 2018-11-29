package com.pass.cloud.opc.model.dto.robot;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@ApiModel(value = "text类型")
public class TextDto implements Serializable {

    private static final long serialVersionUID = 8825625125019746717L;

    @ApiModelProperty(value = "消息内容", required = true)
    private String content;

}
