package com.manager.provider.feigin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author sunli
 * @date 2020/5/30 4:20
 */
@FeignClient(value = "nacos-redis-consumer")
public interface RedisInterface {

    @GetMapping("/removeKey/{key}")
    public void remove(@PathVariable("key") String key);

    @PostMapping("/saveToken")
    public void save(@RequestBody Map<String, Object> queryParam);
}
