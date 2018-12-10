package com.pass.cloud.common.bean.result;

import java.io.Serializable;

import com.pass.cloud.common.util.json.HttpGsonBuilder;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

/**
 * @author Daniel Qian
 */
@Data
public class HttpMediaUploadResult implements Serializable {

    private static final long serialVersionUID = 330834334738622341L;

    private String url;
    private String type;
    private String mediaId;
    private String thumbMediaId;
    private long createdAt;

    public static HttpMediaUploadResult fromJson(String json) {
        return HttpGsonBuilder.create().fromJson(json, HttpMediaUploadResult.class);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
