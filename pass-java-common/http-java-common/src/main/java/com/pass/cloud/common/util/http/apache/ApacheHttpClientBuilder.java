package com.pass.cloud.common.util.http.apache;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * httpclient build interface.
 *
 * @author kakotor
 */
public interface ApacheHttpClientBuilder {

    /**
     * 构建httpclient实例.
     *
     * @return new instance of CloseableHttpClient
     */
    CloseableHttpClient build();

    /**
     * 代理服务器地址.
     *
     * @param httpProxyHost
     * @return ApacheHttpClientBuilder
     */
    ApacheHttpClientBuilder httpProxyHost(String httpProxyHost);

    /**
     * 代理服务器端口.
     *
     * @param httpProxyPort
     * @return ApacheHttpClientBuilder
     */
    ApacheHttpClientBuilder httpProxyPort(int httpProxyPort);

    /**
     * 代理服务器用户名.
     *
     * @param httpProxyUsername
     * @return ApacheHttpClientBuilder
     */
    ApacheHttpClientBuilder httpProxyUsername(String httpProxyUsername);

    /**
     * 代理服务器密码.
     *
     * @param httpProxyPassword
     * @return ApacheHttpClientBuilder
     */
    ApacheHttpClientBuilder httpProxyPassword(String httpProxyPassword);

    /**
     * ssl连接socket工厂.
     *
     * @param sslConnectionSocketFactory
     * @return ApacheHttpClientBuilder
     */
    ApacheHttpClientBuilder sslConnectionSocketFactory(SSLConnectionSocketFactory sslConnectionSocketFactory);
}
