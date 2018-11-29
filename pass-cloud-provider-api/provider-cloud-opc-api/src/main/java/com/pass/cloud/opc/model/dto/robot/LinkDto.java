package com.pass.cloud.opc.model.dto.robot;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@ApiModel(value = "link类型")
public class LinkDto implements Serializable {

    private static final long serialVersionUID = 414254079011512757L;

    @ApiModelProperty(value = "消息标题", required = true)
    private String title;

    @ApiModelProperty(value = "消息内容。如果太长只会部分展示", required = true)
    private String text;

    @ApiModelProperty(value = "点击消息跳转的URL", required = true)
    private String messageUrl;

    @ApiModelProperty(value = "图片URL")
    private String picUrl;

}
