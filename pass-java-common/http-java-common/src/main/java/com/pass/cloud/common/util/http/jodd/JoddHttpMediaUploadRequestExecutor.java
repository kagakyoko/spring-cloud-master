package com.pass.cloud.common.util.http.jodd;

import java.io.File;
import java.io.IOException;

import com.pass.cloud.common.bean.result.HttpMediaUploadResult;
import com.pass.cloud.common.error.HttpError;
import com.pass.cloud.common.error.HttpErrorException;
import com.pass.cloud.common.util.http.MediaUploadRequestExecutor;
import com.pass.cloud.common.util.http.RequestHttp;

import jodd.http.HttpConnectionProvider;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import jodd.http.ProxyInfo;
import jodd.util.StringPool;

/**
 * @author takesi
 */
public class JoddHttpMediaUploadRequestExecutor extends MediaUploadRequestExecutor<HttpConnectionProvider, ProxyInfo> {

    public JoddHttpMediaUploadRequestExecutor(RequestHttp requestHttp) {
        super(requestHttp);
    }

    @Override
    public HttpMediaUploadResult execute(String uri, File file) throws HttpErrorException, IOException {
        HttpRequest request = HttpRequest.post(uri);
        if (requestHttp.getRequestHttpProxy() != null) {
            requestHttp.getRequestHttpClient().useProxy(requestHttp.getRequestHttpProxy());
        }
        request.withConnectionProvider(requestHttp.getRequestHttpClient());
        request.form("media", file);
        HttpResponse response = request.send();
        response.charset(StringPool.UTF_8);

        String responseContent = response.bodyText();
        HttpError error = HttpError.fromJson(responseContent);
        if (error.getErrorCode() != 0) {
            throw new HttpErrorException(error);
        }
        return HttpMediaUploadResult.fromJson(responseContent);
    }
}
