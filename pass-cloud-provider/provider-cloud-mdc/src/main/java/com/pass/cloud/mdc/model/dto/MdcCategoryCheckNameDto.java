package com.pass.cloud.mdc.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class MdcCategoryCheckNameDto implements Serializable {

    private static final long serialVersionUID = 8687848883145768024L;

    /**
     * 菜单的id
     */
    private Long categoryId;

    /**
     * 菜单的url
     */
    @NotBlank(message = "分类名称不能为空")
    private String categoryName;

}
