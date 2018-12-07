package com.pass.cloud.omc.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class CartVo implements Serializable {

    private static final long serialVersionUID = -7852680577412931768L;

    private List<CartProductVo> cartProductVoList;

    private BigDecimal cartTotalPrice;

    /**
     * 是否已经都勾选
     */
    private Boolean allChecked;

    private String imageHost;

}
