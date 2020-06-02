package com.manager.auth.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * 远程调用redis缓存服务
 * 使用feign
 * @author sunli
 * @date 2020/3/31 0:23
 */
@FeignClient("nacos-redis-consumer")
public interface redisService {

    @PostMapping("/saveToken")
    void save(@RequestBody Map<String, Object> queryParam);
}
