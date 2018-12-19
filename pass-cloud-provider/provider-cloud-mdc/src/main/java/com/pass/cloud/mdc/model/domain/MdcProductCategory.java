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
@Alias("mdcProductCategory")
@EqualsAndHashCode(callSuper = true)
@Table(name = "pc_mdc_product_category")
public class MdcProductCategory extends BaseEntity {

    private static final long serialVersionUID = 6966836239624795099L;

    /**
     * 分类编码
     */
    @Column(name = "category_code")
    private String categoryCode;

    /**
     * 首图的流水号
     */
    @Column(name = "img_id")
    private Long imgId;

    /**
     * 父类别id当id=0时说明是根节点,一级类别
     */
    private Long pid;

    /**
     * 类别名称
     */
    private String name;

    /**
     * 类别状态1-启用,2-禁用
     * {@link com.pass.cloud.mdc.model.enums.MdcCategoryStatusEnum}
     */
    private Integer status;

    /**
     * 排序编号,同类展示顺序,数值相等则自然排序
     */
    @Column(name = "sort_order")
    private Integer sortOrder;

}
