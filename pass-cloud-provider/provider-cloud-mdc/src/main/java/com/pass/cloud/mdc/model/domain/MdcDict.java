package com.pass.cloud.mdc.model.domain;

import javax.persistence.Column;
import javax.persistence.Table;

import com.pass.cloud.core.mybatis.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * @author takesi
 */
@Data
@Alias("mdcDict")
@Table(name = "pc_mdc_dict")
@EqualsAndHashCode(callSuper = true)
public class MdcDict extends BaseEntity {

    private static final long serialVersionUID = -4257346287088805156L;
    /**
     * 字典类型 -0 常量 - 1 文件夹
     */
    private Integer type;

    /**
     * 枚举编码
     */
    @Column(name = "dict_key")
    private String dictKey;

    /**
     * 枚举扩展字段
     */
    @Column(name = "extend_key")
    private String extendKey;

    /**
     * 枚举值
     */
    @Column(name = "dict_value")
    private String dictValue;

    /**
     * 字典编码
     */
    @Column(name = "dict_code")
    private String dictCode;

    /**
     * 字典名称
     */
    @Column(name = "dict_name")
    private String dictName;

    /**
     * 父ID
     */
    private Long pid;

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
