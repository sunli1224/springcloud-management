package com.manager.redis.service;

/**
 * redis 缓存存取服务
 * @author sunli
 * @date 2020/3/30 22:09
 */
public interface redisSaveService {


    /**
     * 删除key
     * @param key key
     * @throws Exception
     */
    public void removeRedisKeyValue(String key) throws Exception;
    /**
     * 设置缓存值
     * @param key 缓存的key值
     * @param value 缓存的value值
     * @throws Exception
     */
    public void redisSetKeyValue(String key, String value) throws Exception;

    /**
     * 获取缓存值
     * @param key 缓存key值
     * @return 缓存的value值
     * @throws Exception
     */
    public Object getRedisValue(String key) throws Exception;
}
