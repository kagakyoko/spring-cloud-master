package com.pass.cloud.core.manager;

import com.pass.cloud.base.enums.ErrorCodeEnum;
import com.pass.cloud.mdc.exception.MdcBizException;
import com.pass.cloud.mdc.mapper.MdcProductMapper;
import com.pass.cloud.mdc.model.domain.MdcProduct;
import com.pass.cloud.sdk.annotation.MqProducerStore;
import com.pass.cloud.sdk.model.domain.MqMessageData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author takesi
 */
@Slf4j
@Component
@Transactional(rollbackFor = Exception.class)
public class MdcProductManager {

    @Autowired
    private MdcProductMapper mdcProductMapper;

    /**
     * Save product.
     *
     * @param mqMessageData the mq message data
     * @param product       the product
     * @param addFlag       the add flag
     */
    @MqProducerStore
    public void saveProduct(final MqMessageData mqMessageData, final MdcProduct product, boolean addFlag) {
        log.info("保存商品信息. mqMessageData={}, product={}", mqMessageData, product);
        if (addFlag) {
            mdcProductMapper.insertSelective(product);
        } else {
            int result = mdcProductMapper.updateByPrimaryKeySelective(product);
            if (result < 1) {
                throw new MdcBizException(ErrorCodeEnum.MDC10021022, product.getId());
            }
        }
    }

    /**
     * Delete product.
     *
     * @param mqMessageData the mq message data
     * @param productId     the product id
     */
    @MqProducerStore
    public void deleteProduct(final MqMessageData mqMessageData, final Long productId) {
        log.info("删除商品信息. mqMessageData={}, productId={}", mqMessageData, productId);
        int result = mdcProductMapper.deleteByPrimaryKey(productId);
        if (result < 1) {
            throw new MdcBizException(ErrorCodeEnum.MDC10021023, productId);
        }
    }

}
