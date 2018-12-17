package com.pass.cloud.uac.model.dto.action;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class UacActionCheckCodeDto implements Serializable {

    private static final long serialVersionUID = 8687848883145768024L;

    /**
     * 权限的id
     */
    private Long actionId;

    /**
     * 权限的url
     */
    @NotBlank(message = "权限编码不能为空")
    private String actionCode;

}
