package com.manager.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 学生管理模块
 * @author sunli
 * @date 2020/3/14 16:04
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(value = "com.manager.mapper")
public class managerProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(managerProviderApplication.class,args);
    }
}
