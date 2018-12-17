package com.pass.cloud.base.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class UpdateStatusDto implements Serializable {

    private static final long serialVersionUID = 1494899235149813850L;

    /**
     * 角色ID
     */
    private Long id;

    /**
     * 状态
     */
    private Integer status;

}
