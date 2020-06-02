package com.manager.redis.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 *
 * redis 缓存服务
 * @author sunli
 * @date 2020/3/30 22:10
 */
@Service
public class redisSaveServiceImpl implements redisSaveService {
    @Override
    public void removeRedisKeyValue(String key) throws Exception {
        redisTemplate.delete(key);
    }

    @Override
    public void redisSetKeyValue(String key, String value) throws Exception {
        redisTemplate.opsForValue().set(key,value,60*30, TimeUnit.SECONDS);
    }

    @Override
    public Object getRedisValue(String key) throws Exception {
        return redisTemplate.opsForValue().get(key);
    }


    @Resource
    private RedisTemplate<String,Object> redisTemplate;
}
