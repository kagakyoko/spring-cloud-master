package com.pass.cloud.mdc.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class MdcDictCheckNameDto implements Serializable {

    private static final long serialVersionUID = 8687848883145768024L;

    /**
     * 菜单的id
     */
    private Long dictId;

    /**
     * 菜单的url
     */
    @NotBlank(message = "数据字典名称不能为空")
    private String dictName;

}
