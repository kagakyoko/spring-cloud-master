package com.pass.cloud.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author takesi
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDiscoveryApplication.class, args);
    }
}
