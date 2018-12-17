package com.pass.cloud.opc.model.dto.robot;

import java.io.Serializable;

import lombok.Data;

/**
 * link类型
 *
 * @author takesi
 */
@Data
public class LinkDto implements Serializable {

    private static final long serialVersionUID = 414254079011512757L;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息内容。如果太长只会部分展示
     */
    private String text;

    /**
     * 点击消息跳转的URL
     */
    private String messageUrl;

    /**
     * 图片URL
     */
    private String picUrl;

}
