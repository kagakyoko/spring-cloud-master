package com.pass.cloud.mdc.model.vo;

import com.pass.cloud.base.dto.BaseTree;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MdcDictVo extends BaseTree<MdcDictVo, Long> {

    private static final long serialVersionUID = -6759243808584390573L;

    /**
     * 父数据字典名称
     */
    private String parentDictName;

    /**
     * 字典类型 -0 常量 - 1 文件夹
     */
    private Integer type;

    /**
     * 枚举编码
     */
    private String dictKey;

    /**
     * 枚举扩展字段
     */
    private String extendKey;

    /**
     * 枚举值
     */
    private String dictValue;

    /**
     * 字典编码
     */
    private String dictCode;

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 序号
     */
    private Integer number;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

}
