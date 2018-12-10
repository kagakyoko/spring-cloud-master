package com.pass.cloud.common.util.json;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.pass.cloud.common.error.HttpError;

/**
 * @author Daniel Qian.
 */
public class HttpErrorAdapter implements JsonDeserializer<HttpError> {

    @Override
    public HttpError deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        HttpError.HttpErrorBuilder errorBuilder = HttpError.builder();
        JsonObject wxErrorJsonObject = json.getAsJsonObject();

        if (wxErrorJsonObject.get("errcode") != null && !wxErrorJsonObject.get("errcode").isJsonNull()) {
            errorBuilder.errorCode(GsonHelper.getAsPrimitiveInt(wxErrorJsonObject.get("errcode")));
        }
        if (wxErrorJsonObject.get("errmsg") != null && !wxErrorJsonObject.get("errmsg").isJsonNull()) {
            errorBuilder.errorMsg(GsonHelper.getAsString(wxErrorJsonObject.get("errmsg")));
        }

        errorBuilder.json(json.toString());

        return errorBuilder.build();
    }

}
