package com.pass.cloud.common.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pass.cloud.common.bean.HttpAccessToken;
import com.pass.cloud.common.bean.result.HttpMediaUploadResult;
import com.pass.cloud.common.error.HttpError;

/**
 * @author takesi
 */
public class HttpGsonBuilder {

    public static final GsonBuilder INSTANCE = new GsonBuilder();

    static {
        INSTANCE.disableHtmlEscaping();
        INSTANCE.registerTypeAdapter(HttpAccessToken.class, new HttpAccessTokenAdapter());
        INSTANCE.registerTypeAdapter(HttpError.class, new HttpErrorAdapter());
        INSTANCE.registerTypeAdapter(HttpMediaUploadResult.class, new HttpMediaUploadResultAdapter());
    }

    public static Gson create() {
        return INSTANCE.create();
    }

}
