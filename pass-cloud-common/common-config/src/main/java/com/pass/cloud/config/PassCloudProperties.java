package com.pass.cloud.config;

import com.pass.cloud.base.constant.GlobalConstant;
import com.pass.cloud.config.properties.AliyunProperties;
import com.pass.cloud.config.properties.AsyncTaskProperties;
import com.pass.cloud.config.properties.JobProperties;
import com.pass.cloud.config.properties.QiniuProperties;
import com.pass.cloud.config.properties.ReliableMessageProperties;
import com.pass.cloud.config.properties.SwaggerProperties;
import com.pass.cloud.config.properties.ZookeeperProperties;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author takesi
 */
@Getter
@ConfigurationProperties(prefix = GlobalConstant.ROOT_PREFIX)
public class PassCloudProperties {

    private ReliableMessageProperties message = new ReliableMessageProperties();

    private AliyunProperties aliyun = new AliyunProperties();

    private AsyncTaskProperties task = new AsyncTaskProperties();

    private SwaggerProperties swagger = new SwaggerProperties();

    private QiniuProperties qiniu = new QiniuProperties();

    private JobProperties job = new JobProperties();

    private ZookeeperProperties zk = new ZookeeperProperties();

    public void setMessage(ReliableMessageProperties message) {
        this.message = message;
    }

    public void setAliyun(AliyunProperties aliyun) {
        this.aliyun = aliyun;
    }

    public void setTask(AsyncTaskProperties task) {
        this.task = task;
    }

    public void setSwagger(SwaggerProperties swagger) {
        this.swagger = swagger;
    }

    public void setQiniu(QiniuProperties qiniu) {
        this.qiniu = qiniu;
    }

    public void setJob(JobProperties job) {
        this.job = job;
    }

    public void setZk(ZookeeperProperties zk) {
        this.zk = zk;
    }
}
