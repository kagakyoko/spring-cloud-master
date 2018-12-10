package com.pass.cloud.common.util.http.apache;

import java.io.IOException;

import com.pass.cloud.common.error.HttpError;
import com.pass.cloud.common.error.HttpErrorException;
import com.pass.cloud.common.util.http.RequestHttp;
import com.pass.cloud.common.util.http.SimplePostRequestExecutor;

import org.apache.http.Consts;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * @author takesi
 */
public class ApacheSimplePostRequestExecutor extends SimplePostRequestExecutor<CloseableHttpClient, HttpHost> {

    public ApacheSimplePostRequestExecutor(RequestHttp requestHttp) {
        super(requestHttp);
    }

    @Override
    public String execute(String uri, String postEntity) throws HttpErrorException, IOException {
        HttpPost httpPost = new HttpPost(uri);
        if (requestHttp.getRequestHttpProxy() != null) {
            RequestConfig config = RequestConfig.custom().setProxy(requestHttp.getRequestHttpProxy()).build();
            httpPost.setConfig(config);
        }

        if (postEntity != null) {
            StringEntity entity = new StringEntity(postEntity, Consts.UTF_8);
            httpPost.setEntity(entity);
        }

        try (CloseableHttpResponse response = requestHttp.getRequestHttpClient().execute(httpPost)) {
            String responseContent = Utf8ResponseHandler.INSTANCE.handleResponse(response);
            if (responseContent.isEmpty()) {
                throw new HttpErrorException(HttpError.builder().errorCode(9999).errorMsg("无响应内容").build());
            }

            if (responseContent.startsWith("<xml>")) {
                //xml格式输出直接返回
                return responseContent;
            }

            HttpError error = HttpError.fromJson(responseContent);
            if (error.getErrorCode() != 0) {
                throw new HttpErrorException(error);
            }
            return responseContent;
        } finally {
            httpPost.releaseConnection();
        }
    }
}
