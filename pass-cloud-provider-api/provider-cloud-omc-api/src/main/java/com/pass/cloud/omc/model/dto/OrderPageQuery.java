package com.pass.cloud.omc.model.dto;

import com.pass.cloud.base.dto.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author takesi
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderPageQuery extends BaseQuery {

    private static final long serialVersionUID = -7997684399705866704L;

    /**
     * 状态
     */
    private String status;

    /**
     * 订单号
     */
    private String orderNo;

}
