package com.pass.cloud.common.bean;

import java.io.Serializable;

import com.pass.cloud.common.util.json.HttpGsonBuilder;

import lombok.Data;

/**
 * access token.
 *
 * @author takesi
 */
@Data
public class HttpAccessToken implements Serializable {

    private static final long serialVersionUID = 8709719312922168909L;

    private String accessToken;

    private int expiresIn = -1;

    public static HttpAccessToken fromJson(String json) {
        return HttpGsonBuilder.create().fromJson(json, HttpAccessToken.class);
    }

}
