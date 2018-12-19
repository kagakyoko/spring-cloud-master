package com.pass.cloud.uac.model.dto.action;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class UacActionCheckUrlDto implements Serializable {

    private static final long serialVersionUID = 839437721293973234L;

    /**
     * 权限的id
     */
    private Long actionId;

    /**
     * 权限的url
     */
    @NotBlank(message = "权限地址不能为空")
    private String url;

}
