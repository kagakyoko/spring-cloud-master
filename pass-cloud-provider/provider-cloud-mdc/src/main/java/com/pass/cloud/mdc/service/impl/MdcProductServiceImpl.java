package com.pass.cloud.mdc.service.impl;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.pass.cloud.JacksonUtil;
import com.pass.cloud.PubUtils;
import com.pass.cloud.PublicUtil;
import com.pass.cloud.RedisKeyUtil;
import com.pass.cloud.base.constant.AliyunMqTopicConstants;
import com.pass.cloud.base.constant.GlobalConstant;
import com.pass.cloud.base.dto.LoginAuthDto;
import com.pass.cloud.base.enums.ErrorCodeEnum;
import com.pass.cloud.core.manager.MdcProductManager;
import com.pass.cloud.core.support.BaseService;
import com.pass.cloud.mdc.mapper.MdcProductMapper;
import com.pass.cloud.mdc.model.domain.MdcProduct;
import com.pass.cloud.mdc.model.dto.MdcEditProductDto;
import com.pass.cloud.mdc.model.dto.ProductDto;
import com.pass.cloud.mdc.model.vo.ProductDetailVo;
import com.pass.cloud.mdc.model.vo.ProductVo;
import com.pass.cloud.mdc.service.MdcProductService;
import com.pass.cloud.sdk.model.domain.MqMessageData;
import com.pass.cloud.sdk.model.dto.UpdateAttachmentDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author takesi
 */
@Service
public class MdcProductServiceImpl extends BaseService<MdcProduct> implements MdcProductService {

    @Autowired
    private MdcProductMapper mdcProductMapper;

    @Autowired
    private MdcProductManager mdcProductManager;

    @Override
    public List<MdcProduct> selectByNameAndCategoryIds(String productName, List<Long> categoryIdList, String orderBy) {
        return mdcProductMapper.selectByNameAndCategoryIds(productName, categoryIdList, orderBy);
    }

    @Override
    public ProductDetailVo getProductDetail(Long productId) {
        Preconditions.checkArgument(productId != null, ErrorCodeEnum.MDC10021021.msg());
        return null;
    }

    @Override
    public int updateProductStockById(ProductDto productDto) {
        Preconditions.checkArgument(!PubUtils.isNull(productDto, productDto.getId()), ErrorCodeEnum.MDC10021021.msg());
        return mdcProductMapper.updateProductStockById(productDto);
    }

    @Override
    public List<ProductVo> queryProductListWithPage(MdcProduct mdcProduct) {
        return mdcProductMapper.queryProductListWithPage(mdcProduct);
    }

    @Override
    public void saveProduct(final MdcEditProductDto mdcEditProductDto, final LoginAuthDto loginAuthDto) throws JsonProcessingException {
        String productCode = mdcEditProductDto.getProductCode();
        MdcProduct product = new MdcProduct();
        BeanUtils.copyProperties(mdcEditProductDto, product);
        List<Long> categoryIdList = mdcEditProductDto.getCategoryIdList();
        Long categoryId = categoryIdList.get(categoryIdList.size() - 1);
        product.setCategoryId(categoryId);
        List<Long> attachmentIdList = mdcEditProductDto.getAttachmentIdList();
        product.setUpdateInfo(loginAuthDto);

        if (PublicUtil.isNotEmpty(attachmentIdList)) {
            product.setMainImage(String.valueOf(attachmentIdList.get(0)));
            product.setSubImages(Joiner.on(GlobalConstant.Symbol.COMMA).join(attachmentIdList));
        }
        MqMessageData mqMessageData;
        if (product.isNew()) {
            productCode = String.valueOf(generateId());
        } else {
            Preconditions.checkArgument(StringUtils.isNotEmpty(productCode), ErrorCodeEnum.MDC10021024.msg());
        }
        product.setProductCode(productCode);
        UpdateAttachmentDto updateAttachmentDto = new UpdateAttachmentDto(productCode, attachmentIdList, loginAuthDto);

        String body = JacksonUtil.OBJECT_MAPPER.writeValueAsString(updateAttachmentDto);
        String topic = AliyunMqTopicConstants.MqTagEnum.UPDATE_ATTACHMENT.getTopic();
        String tag = AliyunMqTopicConstants.MqTagEnum.UPDATE_ATTACHMENT.getTag();
        String key = RedisKeyUtil.createMqKey(topic, tag, product.getProductCode(), body);

        if (product.isNew() && PublicUtil.isNotEmpty(attachmentIdList)) {
            product.setId(generateId());
            mqMessageData = new MqMessageData(body, topic, tag, key);
            mdcProductManager.saveProduct(mqMessageData, product, true);
        } else if (product.isNew() && PublicUtil.isEmpty(attachmentIdList)) {
            product.setId(generateId());
            mdcProductMapper.insertSelective(product);
        } else {
            mqMessageData = new MqMessageData(body, topic, tag, key);
            mdcProductManager.saveProduct(mqMessageData, product, false);
        }
    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public ProductVo getProductVo(Long id) {
        return null;
    }

    @Override
    public String getMainImage(Long productId) {
        return null;
    }

}
