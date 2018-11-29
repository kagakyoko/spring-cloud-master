package com.pass.cloud.mdc.model.vo;

import com.pass.cloud.base.dto.BaseTree;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MdcCategoryVo extends BaseTree<MdcCategoryVo, Long> {

    private static final long serialVersionUID = 5310269803239754048L;
    /**
     * 父分类名称
     */
    @ApiModelProperty(value = "父分类名称")
    private String parentCategoryName;
    /**
     * 字典类型 -0 常量 - 1 文件夹
     */
    @ApiModelProperty(value = "字典类型 -0 常量 - 1 文件夹")
    private Integer type;

    /**
     * 字典名称
     */
    @ApiModelProperty(value = "字典名称")
    private String name;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private Integer number;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Integer status;
    /**
     * 排序编号,同类展示顺序,数值相等则自然排序
     */
    @ApiModelProperty(value = "排序编号,同类展示顺序,数值相等则自然排序")
    private Integer sortOrder;
    /**
     * 分类编码
     */
    @ApiModelProperty(value = "分类编码")
    private String categoryCode;

}
