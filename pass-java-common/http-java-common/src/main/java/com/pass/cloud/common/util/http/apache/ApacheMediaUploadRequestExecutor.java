package com.pass.cloud.common.util.http.apache;

import java.io.File;
import java.io.IOException;

import com.pass.cloud.common.bean.result.HttpMediaUploadResult;
import com.pass.cloud.common.error.HttpError;
import com.pass.cloud.common.error.HttpErrorException;
import com.pass.cloud.common.util.http.MediaUploadRequestExecutor;
import com.pass.cloud.common.util.http.RequestHttp;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * @author takesi
 */
public class ApacheMediaUploadRequestExecutor extends MediaUploadRequestExecutor<CloseableHttpClient, HttpHost> {

    public ApacheMediaUploadRequestExecutor(RequestHttp requestHttp) {
        super(requestHttp);
    }

    @Override
    public HttpMediaUploadResult execute(String uri, File file) throws HttpErrorException, IOException {
        HttpPost httpPost = new HttpPost(uri);
        if (requestHttp.getRequestHttpProxy() != null) {
            RequestConfig config = RequestConfig.custom().setProxy(requestHttp.getRequestHttpProxy()).build();
            httpPost.setConfig(config);
        }
        if (file != null) {
            HttpEntity entity = MultipartEntityBuilder
                    .create()
                    .addBinaryBody("media", file)
                    .setMode(HttpMultipartMode.RFC6532)
                    .build();
            httpPost.setEntity(entity);
        }
        try (CloseableHttpResponse response = requestHttp.getRequestHttpClient().execute(httpPost)) {
            String responseContent = Utf8ResponseHandler.INSTANCE.handleResponse(response);
            HttpError error = HttpError.fromJson(responseContent);
            if (error.getErrorCode() != 0) {
                throw new HttpErrorException(error);
            }
            return HttpMediaUploadResult.fromJson(responseContent);
        } finally {
            httpPost.releaseConnection();
        }
    }
}
