package com.pass.cloud.mdc.model.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class AddressDTO implements Serializable {

    private static final long serialVersionUID = -154171216711236047L;

    /**
     * ID
     */
    private Long id;

    /**
     * 地址名称
     */
    private String name;

    /**
     * 父ID
     */
    private Long pid;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 级别（省市区县）
     */
    private Integer level;

    /**
     * 区域编码
     */
    private String adCode;

    /**
     * 行政区边界坐标点
     */
    private String polyLine;

    /**
     * 城市中心点
     */
    private String center;

}
