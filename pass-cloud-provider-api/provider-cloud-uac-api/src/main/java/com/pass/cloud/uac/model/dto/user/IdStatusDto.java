package com.pass.cloud.uac.model.dto.user;

import java.io.Serializable;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class IdStatusDto implements Serializable {

    private static final long serialVersionUID = -1976690893998068416L;

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 推送状态
     */
    private Integer status;

}
