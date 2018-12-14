package com.pass.cloud.base.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author takesi
 */
@Data
@ApiModel
public class BaseVo implements Serializable {

    private static final long serialVersionUID = -1695850022460957581L;

    @ApiModelProperty(value = "ID")
    private Long id;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String creator;
    /**
     * 创建人ID
     */
    @ApiModelProperty(value = "创建人ID")
    private Long creatorId;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;
    /**
     * 最近操作人
     */
    @ApiModelProperty(value = "最近操作人")
    private String lastOperator;
    /**
     * 最后操作人ID
     */
    @ApiModelProperty(value = "最后操作人ID")
    private Long lastOperatorId;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}
