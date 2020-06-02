package com.manager.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sunli
 * @date 2020/3/14 18:03
 */
@SpringBootApplication
@EnableDiscoveryClient
public class managerConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(managerConsumerApplication.class,args);
    }
}
