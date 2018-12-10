package com.pass.cloud.common.util.http;

/**
 * @author takesi
 */
public interface RequestHttp<H, P> {

    /**
     * 返回httpClient
     *
     * @return H
     */
    H getRequestHttpClient();

    /**
     * 返回httpProxy
     *
     * @return P
     */
    P getRequestHttpProxy();

    /**
     * @return HttpType
     */
    HttpType getRequestType();

}
