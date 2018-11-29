package com.pass.cloud.opc.model.dto.robot;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@ApiModel("markdown类型")
public class MarkdownDto implements Serializable {

    private static final long serialVersionUID = 5169795915361197484L;
    /**
     * 首屏会话透出的展示内容
     */
    @ApiModelProperty(value = "首屏会话透出的展示内容", required = true)
    private String title;
    /**
     * markdown格式的消息
     */
    @ApiModelProperty(value = "markdown格式的消息", required = true)
    private String text;

}
