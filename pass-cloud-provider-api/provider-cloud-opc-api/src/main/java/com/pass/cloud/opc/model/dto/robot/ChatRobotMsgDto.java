package com.pass.cloud.opc.model.dto.robot;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 自定义机器人消息体
 *
 * @author takesi
 */
@Data
public class ChatRobotMsgDto implements Serializable {

    private static final long serialVersionUID = -9132398786027223009L;

    /**
     * 机器人URL
     */
    private String webHookToken;

    /**
     * 首屏会话透出的展示内容
     * 此消息类型为固定markdown
     * {@link com.pass.cloud.opc.model.enums.RobotMsgTypeEnum}
     */
    @JsonProperty(value = "msg_type")
    private String msgType;

    /**
     * markdown消息体
     */
    private MarkdownDto markdown;

    /**
     * link类型
     */
    private LinkDto link;
    /**
     * link类型
     */
    private TextDto text;
    /**
     * link类型
     */
    private AtDto at;

}
