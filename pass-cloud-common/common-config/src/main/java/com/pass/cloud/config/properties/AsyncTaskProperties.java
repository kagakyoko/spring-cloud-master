package com.pass.cloud.config.properties;

import lombok.Data;

/**
 * @author takesi
 */
@Data
public class AsyncTaskProperties {

    private int corePoolSize = 50;

    private int maxPoolSize = 100;

    private int queueCapacity = 10000;

    private int keepAliveSeconds = 3000;

    private String threadNamePrefix = "passcloud-task-executor-";

}
