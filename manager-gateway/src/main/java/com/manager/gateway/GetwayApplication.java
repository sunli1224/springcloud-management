package com.manager.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;



/**
 * 网关服务
 * @author sunli
 * @date 2020/3/23 4:33
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class GetwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetwayApplication.class,args);
    }
}
