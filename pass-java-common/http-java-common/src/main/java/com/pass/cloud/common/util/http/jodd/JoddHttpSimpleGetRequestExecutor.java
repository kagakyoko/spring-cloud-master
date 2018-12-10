package com.pass.cloud.common.util.http.jodd;

import java.io.IOException;

import com.pass.cloud.common.error.HttpError;
import com.pass.cloud.common.error.HttpErrorException;
import com.pass.cloud.common.util.http.RequestHttp;
import com.pass.cloud.common.util.http.SimpleGetRequestExecutor;

import jodd.http.HttpConnectionProvider;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import jodd.http.ProxyInfo;
import jodd.util.StringPool;

/**
 * @author takesi
 */
public class JoddHttpSimpleGetRequestExecutor extends SimpleGetRequestExecutor<HttpConnectionProvider, ProxyInfo> {

    public JoddHttpSimpleGetRequestExecutor(RequestHttp requestHttp) {
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

        HttpRequest request = HttpRequest.get(uri);
        if (requestHttp.getRequestHttpProxy() != null) {
            requestHttp.getRequestHttpClient().useProxy(requestHttp.getRequestHttpProxy());
        }
        request.withConnectionProvider(requestHttp.getRequestHttpClient());
        HttpResponse response = request.send();
        response.charset(StringPool.UTF_8);

        String responseContent = response.bodyText();

        HttpError error = HttpError.fromJson(responseContent);
        if (error.getErrorCode() != 0) {
            throw new HttpErrorException(error);
        }
        return responseContent;
    }

}
