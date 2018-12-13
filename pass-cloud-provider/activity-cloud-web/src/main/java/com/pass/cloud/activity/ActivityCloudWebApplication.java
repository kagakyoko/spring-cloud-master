package com.pass.cloud.activity;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author takesi
 */
@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class
})
public class ActivityCloudWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivityCloudWebApplication.class, args);
    }
}
