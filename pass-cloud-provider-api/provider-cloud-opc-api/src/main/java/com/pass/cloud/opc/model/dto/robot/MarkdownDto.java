package com.pass.cloud.opc.model.dto.robot;

import java.io.Serializable;

import lombok.Data;

/**
 * markdown类型
 *
 * @author takesi
 */
@Data
public class MarkdownDto implements Serializable {

    private static final long serialVersionUID = 5169795915361197484L;

    /**
     * 首屏会话透出的展示内容
     */
    private String title;

    /**
     * markdown格式的消息
     */
    private String text;

}
