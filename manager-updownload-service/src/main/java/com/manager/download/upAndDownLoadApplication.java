package com.manager.download;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author sunli
 * @date 2020/5/14 16:26
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class upAndDownLoadApplication {
    public static void main(String[] args) {
        SpringApplication.run(upAndDownLoadApplication.class, args);
    }
}
