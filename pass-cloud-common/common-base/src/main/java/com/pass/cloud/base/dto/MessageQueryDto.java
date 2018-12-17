package com.pass.cloud.base.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author takesi
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MessageQueryDto extends BaseQuery {

    private static final long serialVersionUID = 3967075132487249652L;

    /**
     * messageKey
     */
    private String messageKey;

    /**
     * messageTopic
     */
    private String messageTopic;

    /**
     * messageTag
     */
    private String messageTag;

    /**
     * 发送状态
     */
    private String messageStatus;

    /**
     * PID
     */
    private String producerGroup;

    /**
     * 消息类型
     */
    private String messageType;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startQueryTime;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endQueryTime;

}
