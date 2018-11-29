package com.pass.cloud.opc.model.dto.robot;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@ApiModel(value = "AtDto")
public class AtDto implements Serializable {

    private static final long serialVersionUID = 2344037651462081640L;
    /**
     * 被@人的手机号
     */
    @ApiModelProperty(value = "被@人的手机号")
    private String[] atMobiles;
    /**
     * \@所有人时:true,否则为:false
     */
    @ApiModelProperty(value = "@所有人时:true,否则为:false")
    private boolean isAtAll;

}
