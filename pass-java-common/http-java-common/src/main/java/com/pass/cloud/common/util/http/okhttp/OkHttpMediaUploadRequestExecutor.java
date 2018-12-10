package com.pass.cloud.common.util.http.okhttp;

import java.io.File;
import java.io.IOException;

import com.pass.cloud.common.bean.result.HttpMediaUploadResult;
import com.pass.cloud.common.error.HttpError;
import com.pass.cloud.common.error.HttpErrorException;
import com.pass.cloud.common.util.http.MediaUploadRequestExecutor;
import com.pass.cloud.common.util.http.RequestHttp;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author takesi
 */
public class OkHttpMediaUploadRequestExecutor extends MediaUploadRequestExecutor<OkHttpClient, OkHttpProxyInfo> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public OkHttpMediaUploadRequestExecutor(RequestHttp requestHttp) {
        super(requestHttp);
    }

    @Override
    public HttpMediaUploadResult execute(String uri, File file) throws HttpErrorException, IOException {
        logger.debug("OkHttpMediaUploadRequestExecutor is running");
        //得到httpClient
        OkHttpClient client = requestHttp.getRequestHttpClient();

        RequestBody body = new MultipartBody.Builder()
                .setType(MediaType.parse("multipart/form-data"))
                .addFormDataPart("media",
                        file.getName(),
                        RequestBody.create(MediaType.parse("application/octet-stream"), file))
                .build();
        Request request = new Request.Builder().url(uri).post(body).build();

        Response response = client.newCall(request).execute();
        String responseContent = response.body().string();
        HttpError error = HttpError.fromJson(responseContent);
        if (error.getErrorCode() != 0) {
            throw new HttpErrorException(error);
        }
        return HttpMediaUploadResult.fromJson(responseContent);
    }

}
