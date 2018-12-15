package com.pass.cloud.config;

import com.pass.cloud.base.constant.GlobalConstant;
import com.pass.cloud.config.properties.AliyunProperties;
import com.pass.cloud.config.properties.AsyncTaskProperties;
import com.pass.cloud.config.properties.JobProperties;
import com.pass.cloud.config.properties.QiniuProperties;
import com.pass.cloud.config.properties.ReliableMessageProperties;
import com.pass.cloud.config.properties.SwaggerProperties;
import com.pass.cloud.config.properties.ZookeeperProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author takesi
 */
@Data
@ConfigurationProperties(prefix = GlobalConstant.ROOT_PREFIX)
public class PassCloudProperties {

    private ReliableMessageProperties message = new ReliableMessageProperties();

    private AliyunProperties aliyun = new AliyunProperties();

    private AsyncTaskProperties task = new AsyncTaskProperties();

    private SwaggerProperties swagger = new SwaggerProperties();

    private QiniuProperties qiniu = new QiniuProperties();

    private JobProperties job = new JobProperties();

    private ZookeeperProperties zk = new ZookeeperProperties();

}
