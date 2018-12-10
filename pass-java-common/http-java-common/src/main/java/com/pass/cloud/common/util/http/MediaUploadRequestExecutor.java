package com.pass.cloud.common.util.http;

import java.io.File;

import com.pass.cloud.common.bean.result.HttpMediaUploadResult;
import com.pass.cloud.common.util.http.apache.ApacheMediaUploadRequestExecutor;
import com.pass.cloud.common.util.http.jodd.JoddHttpMediaUploadRequestExecutor;
import com.pass.cloud.common.util.http.okhttp.OkHttpMediaUploadRequestExecutor;

/**
 * 上传媒体文件请求执行器，请求的参数是File, 返回的结果是String
 *
 * @author Daniel Qian
 */
public abstract class MediaUploadRequestExecutor<H, P> implements RequestExecutor<HttpMediaUploadResult, File> {

    protected RequestHttp<H, P> requestHttp;

    public MediaUploadRequestExecutor(RequestHttp requestHttp) {
        this.requestHttp = requestHttp;
    }

    public static RequestExecutor<HttpMediaUploadResult, File> create(RequestHttp requestHttp) {
        switch (requestHttp.getRequestType()) {
            case APACHE_HTTP:
                return new ApacheMediaUploadRequestExecutor(requestHttp);
            case JODD_HTTP:
                return new JoddHttpMediaUploadRequestExecutor(requestHttp);
            case OK_HTTP:
                return new OkHttpMediaUploadRequestExecutor(requestHttp);
            default:
                return null;
        }
    }

}
