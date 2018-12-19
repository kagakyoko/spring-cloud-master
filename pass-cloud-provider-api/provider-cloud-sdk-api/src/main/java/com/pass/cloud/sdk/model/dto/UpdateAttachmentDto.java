package com.pass.cloud.sdk.model.dto;

import java.io.Serializable;
import java.util.List;

import com.pass.cloud.base.dto.LoginAuthDto;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@AllArgsConstructor
public class UpdateAttachmentDto implements Serializable {

    private static final long serialVersionUID = -768471033009336091L;

    private String refNo;

    /**
     * 商品图片流水号集合
     */
    private List<Long> attachmentIdList;

    /**
     * 操作人信息
     */
    private LoginAuthDto loginAuthDto;

    public UpdateAttachmentDto() {
        super();
    }

}
