package com.pass.cloud.common.error;

import java.io.Serializable;

import com.pass.cloud.common.util.json.HttpGsonBuilder;

import org.apache.commons.lang3.StringUtils;

import lombok.Builder;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@Builder
public class HttpError implements Serializable {

    private static final long serialVersionUID = 7869786563361406291L;

    /**
     * 错误代码.
     */
    private int errorCode;

    /**
     * 错误信息.
     * （如果可以翻译为中文，就为中文）
     */
    private String errorMsg;

    /**
     * 返回的错误原始信息（英文）.
     */
    private String errorMsgEn;

    private String json;

    public static HttpError fromJson(String json) {
        final HttpError httpError = HttpGsonBuilder.create().fromJson(json, HttpError.class);
        if (StringUtils.isNotEmpty(httpError.getErrorMsg())) {
            httpError.setErrorMsgEn(httpError.getErrorMsg());
        }

        return httpError;
    }

    @Override
    public String toString() {
        if (this.json != null) {
            return this.json;
        }
        return "错误: Code=" + this.errorCode + ", Msg=" + this.errorMsg;
    }

}
