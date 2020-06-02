package com.manager.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author sunli
 * @date 2020/3/14 18:16
 */
@RestController
public class TestController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping(value = "/consumer/echo/{id}")
    public String payTest(@PathVariable("id")String id) {
        return restTemplate.getForObject(serverURL + "/echo/" + id,String.class);
    }



}
