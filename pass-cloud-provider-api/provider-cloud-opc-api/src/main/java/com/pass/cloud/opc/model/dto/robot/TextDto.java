package com.pass.cloud.opc.model.dto.robot;

import java.io.Serializable;

import lombok.Data;

/**
 * text类型
 *
 * @author takesi
 */
@Data
public class TextDto implements Serializable {

    private static final long serialVersionUID = 8825625125019746717L;

    /**
     * 消息内容
     */
    private String content;

}
