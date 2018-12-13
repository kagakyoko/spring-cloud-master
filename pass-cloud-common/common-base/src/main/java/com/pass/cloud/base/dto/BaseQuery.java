package com.pass.cloud.base.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author takesi
 */
@Data
public class BaseQuery implements Serializable {

    private static final long serialVersionUID = 3319698607712846427L;

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private Integer pageNum = 1;
    /**
     * 每页条数
     */
    @ApiModelProperty(value = "每页条数")
    private Integer pageSize = 10;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private String orderBy;

}
