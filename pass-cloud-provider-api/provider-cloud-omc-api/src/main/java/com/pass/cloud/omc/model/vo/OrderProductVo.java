package com.pass.cloud.omc.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class OrderProductVo implements Serializable {

    private static final long serialVersionUID = 9200251296138955758L;

    private List<OrderItemVo> orderItemVoList;

    private BigDecimal productTotalPrice;

    private String imageHost;

}
