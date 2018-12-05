package com.pass.cloud.config;

import com.pass.cloud.base.constant.GlobalConstant;
import com.pass.cloud.config.properties.AliyunProperties;
import com.pass.cloud.config.properties.ZookeeperProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author takesi
 */
@Data
@ConfigurationProperties(prefix = GlobalConstant.ROOT_PREFIX)
public class PassCloudProperties {

    private AliyunProperties aliyun = new AliyunProperties();

    private ZookeeperProperties zk = new ZookeeperProperties();

}
