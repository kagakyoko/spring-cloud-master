package com.pass.cloud.mdc.model.dto;

import com.pass.cloud.base.dto.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductReqDto extends BaseQuery {

    private static final long serialVersionUID = -9070173642901418263L;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 关键词
     */
    private String keyword;

}
