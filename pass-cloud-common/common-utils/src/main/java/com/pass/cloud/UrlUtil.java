package com.pass.cloud;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * url转码、解码
 *
 * @author takesi
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UrlUtil {

    private final static String ENCODE = "GBK";

    /**
     * URL 解码
     */
    public static String getURLDecoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = URLDecoder.decode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            log.error("URL解码失败 ex={}", e.getMessage(), e);
        }
        return result;
    }

    /**
     * URL 转码
     */
    public static String getURLEncoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = URLEncoder.encode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            log.error("URL转码失败 ex={}", e.getMessage(), e);
        }
        return result;
    }

}
