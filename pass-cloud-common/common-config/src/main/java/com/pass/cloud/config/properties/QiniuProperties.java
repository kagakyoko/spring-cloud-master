package com.pass.cloud.config.properties;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class QiniuProperties {

    private QiniuKeyProperties key = new QiniuKeyProperties();

    private QiniuOssProperties oss = new QiniuOssProperties();

    @Data
    public class QiniuKeyProperties {

        private String accessKey;

        private String secretKey;
    }

    @Data
    public class QiniuOssProperties {

        private String privateHost;

        private String publicHost;

        private Long fileMaxSize;
    }

}
