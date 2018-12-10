package com.pass.cloud.uac.model.dto.user;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@ApiModel
public class IdStatusDto implements Serializable {

    private static final long serialVersionUID = -1976690893998068416L;

    @ApiModelProperty(value = "用户ID", required = true)
    private Long id;

    @ApiModelProperty(value = "推送状态", required = true)
    private Integer status;

}
