package com.pass.cloud.core.config;

import java.util.concurrent.Executor;

import com.pass.cloud.config.PassCloudProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author takesi
 */
@Slf4j
@EnableAsync
@Configuration
@EnableScheduling
public class AsyncTaskExecutorConfiguration implements AsyncConfigurer {

    @Autowired
    private PassCloudProperties passCloudProperties;

    @Override
    @Bean(name = "taskExecutor")
    public Executor getAsyncExecutor() {
        log.debug("Creating Async Task Executor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(passCloudProperties.getTask().getCorePoolSize());
        executor.setMaxPoolSize(passCloudProperties.getTask().getMaxPoolSize());
        executor.setQueueCapacity(passCloudProperties.getTask().getQueueCapacity());
        executor.setKeepAliveSeconds(passCloudProperties.getTask().getKeepAliveSeconds());
        executor.setThreadNamePrefix(passCloudProperties.getTask().getThreadNamePrefix());
        return new ExceptionHandlingAsyncTaskExecutor(executor);
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }

}
