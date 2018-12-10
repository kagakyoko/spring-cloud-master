package com.pass.cloud.common.util.http.apache;

import java.io.IOException;

import com.pass.cloud.common.error.HttpError;
import com.pass.cloud.common.error.HttpErrorException;
import com.pass.cloud.common.util.http.RequestHttp;
import com.pass.cloud.common.util.http.SimpleGetRequestExecutor;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * @author takesi
 */
public class ApacheHttpClientSimpleGetRequestExecutor extends SimpleGetRequestExecutor<CloseableHttpClient, HttpHost> {

    public ApacheHttpClientSimpleGetRequestExecutor(RequestHttp requestHttp) {
        super(requestHttp);
    }

    @Override
    public String execute(String uri, String queryParam) throws HttpErrorException, IOException {
        if (queryParam != null) {
            if (uri.indexOf('?') == -1) {
                uri += '?';
            }
            uri += uri.endsWith("?") ? queryParam : '&' + queryParam;
        }
        HttpGet httpGet = new HttpGet(uri);
        if (requestHttp.getRequestHttpProxy() != null) {
            RequestConfig config = RequestConfig.custom().setProxy(requestHttp.getRequestHttpProxy()).build();
            httpGet.setConfig(config);
        }

        try (CloseableHttpResponse response = requestHttp.getRequestHttpClient().execute(httpGet)) {
            String responseContent = Utf8ResponseHandler.INSTANCE.handleResponse(response);
            HttpError error = HttpError.fromJson(responseContent);
            if (error.getErrorCode() != 0) {
                throw new HttpErrorException(error);
            }
            return responseContent;
        } finally {
            httpGet.releaseConnection();
        }
    }

}
