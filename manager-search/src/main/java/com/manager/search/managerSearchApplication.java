package com.manager.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author sunli
 * @date 2020/5/1 11:34
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(value = "com.manager.mapper")
public class managerSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(managerSearchApplication.class, args);
    }
}
