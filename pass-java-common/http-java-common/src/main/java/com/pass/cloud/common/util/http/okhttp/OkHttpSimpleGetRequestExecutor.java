package com.pass.cloud.common.util.http.okhttp;

import java.io.IOException;

import com.pass.cloud.common.error.HttpError;
import com.pass.cloud.common.error.HttpErrorException;
import com.pass.cloud.common.util.http.RequestHttp;
import com.pass.cloud.common.util.http.SimpleGetRequestExecutor;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author takesi
 */
public class OkHttpSimpleGetRequestExecutor extends SimpleGetRequestExecutor<OkHttpClient, OkHttpProxyInfo> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public OkHttpSimpleGetRequestExecutor(RequestHttp requestHttp) {
        super(requestHttp);
    }

    @Override
    public String execute(String uri, String queryParam) throws HttpErrorException, IOException {
        logger.debug("OkHttpSimpleGetRequestExecutor is running");
        if (queryParam != null) {
            if (uri.indexOf('?') == -1) {
                uri += '?';
            }
            uri += uri.endsWith("?") ? queryParam : '&' + queryParam;
        }

        //得到httpClient
        OkHttpClient client = requestHttp.getRequestHttpClient();
        Request request = new Request.Builder().url(uri).build();
        Response response = client.newCall(request).execute();
        String responseContent = response.body().string();
        HttpError error = HttpError.fromJson(responseContent);
        if (error.getErrorCode() != 0) {
            throw new HttpErrorException(error);
        }
        return responseContent;
    }

}
