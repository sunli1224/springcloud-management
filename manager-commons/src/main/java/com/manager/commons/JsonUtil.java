package com.manager.commons;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;
import java.util.Map;

/**
 *对Jason处理工具类
 * @author sunli
 * @date 2020/3/18 16:11
 */
public class JsonUtil {
    private static final SerializeConfig CONFIG;

    static {
        CONFIG = new SerializeConfig();
        // 使用和json-lib兼容的日期输出格式
        CONFIG.put(java.util.Date.class, new JSONLibDataFormatSerializer());
        // 使用和json-lib兼容的日期输出格式
        CONFIG.put(java.sql.Date.class, new JSONLibDataFormatSerializer());
    }

    private static final SerializerFeature[] FEATURES = {
            // 输出空置字段
            SerializerFeature.WriteMapNullValue,
            // list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullListAsEmpty,
            // 数值字段如果为null，输出为0，而不是null
            SerializerFeature.WriteNullNumberAsZero,
            // Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullBooleanAsFalse,
            // 字符类型字段如果为null，输出为""，而不是null
            SerializerFeature.WriteNullStringAsEmpty
    };

    /**
     * 加了Feature配置
     * 将json对象装换为json字符串
     * @param object json对象
     * @return
     */
    public static String convertObjectToJson(Object object) {
        return JSON.toJSONString(object, CONFIG, FEATURES);
    }

    /**
     * 不加配置
     * 将json对象装换为json字符串
     * @param object json对象
     * @return
     */
    public static String toJsonNoFeatures(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * 将json数据转换为object对象
     * @param text json文本数据
     * @return
     */
    public static Object jsonToBean(String text) {
        return JSON.parse(text);
    }

    /**
     * 将json文本数据信息转换为json Object对象
     * @param text json文本数据
     * @param clazz 转换的类型的Class
     * @param <T> 转换的类型
     * @return
     */
    public static <T> T jsonToBean(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }


    /**
     * 转为数组
     * @param text json文本数据
     * @param clazz 转换的类型的Class
     * @param <T> 转换的数组类型
     * @return
     */
    public static <T> Object[] jsonToArray(String text,Class<T> clazz) {
        return JSON.parseArray(text, clazz).toArray();
    }

    /**
     * 转化为List
     * @param text json文本数据
     * @param clazz 转换的类型的Class
     * @param <T> 转换的List的类型
     * @return
     */
    public static <T> List<T> jsonToList(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }

    /**
     * 将json字符串转换为map
     * @param text json文本数据
     * @param <K> map的键值类型
     * @param <V> map的键的值类型
     * @return
     */
    public static <K,V> Map<K,V> jsonToMap(String text) {
        Map<K,V> map = (Map<K, V>) JSONObject.parseObject(text);
        return map;
    }

    /**
     * 将json字符串转换为对象
     * @param str json文本数据
     * @param clazz 某个类型
     * @return
     */
    public static Object jsonToClassObejct(String str, Class<?> clazz) {
        return JSON.parseObject(str,clazz);
    }

    /**
     * 将map转化为string
     * @param map map集合
     * @return
     */
    public static <K, V> String collectToString(Map<K, V> map) {
        return JSONObject.toJSONString(map);
    }

}
