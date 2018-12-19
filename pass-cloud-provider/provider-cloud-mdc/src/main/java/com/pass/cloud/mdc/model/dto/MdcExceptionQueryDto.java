package com.pass.cloud.mdc.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pass.cloud.base.dto.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author takesi
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MdcExceptionQueryDto extends BaseQuery {

    private static final long serialVersionUID = 3967075132487249652L;

    /**
     * 操作用户名称
     */
    private String creator;

    /**
     * 异常原因
     */
    private String exceptionCause;

    /**
     * 异常栈信息
     */
    private String exceptionStack;

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
