package com.pass.cloud.common.util.http;

import java.io.IOException;

import com.pass.cloud.common.error.HttpErrorException;

/**
 * http请求执行器
 *
 * @param <T> 返回值类型
 * @param <E> 请求参数类型
 * @author Daniel Qian
 */
public interface RequestExecutor<T, E> {

    /**
     * 执行请求
     *
     * @param uri
     * @param data
     * @return T
     * @throws HttpErrorException
     * @throws IOException
     */
    T execute(String uri, E data) throws HttpErrorException, IOException;
}
