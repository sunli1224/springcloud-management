package com.manager.redis.controller;

import com.manager.redis.service.redisSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author sunli
 * @date 2020/3/30 22:11
 */
@RestController
public class redisSaveController {

    @GetMapping("/removeKey/{key}")
    public void remove(@PathVariable("key") String key) {
        try {
            redisSaveService.removeRedisKeyValue(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/saveToken")
    public void save(@RequestBody Map<String, Object> queryParam) {
        try {
            redisSaveService.redisSetKeyValue(queryParam.get("username").toString(),queryParam.get("token").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private redisSaveService redisSaveService;
}
