package com.manager.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author sunli
 * @date 2020/3/30 22:06
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class redisServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(redisServiceApplication.class, args);
    }
}
