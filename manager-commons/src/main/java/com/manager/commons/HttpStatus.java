package com.manager.commons;

/**
 *
 * 自定义状态码
 * @author sunli
 * @date 2020/3/18 12:00
 */
public interface HttpStatus {

    /**
     * 请求成功
     */
    int TP_OK = 200;

    /**
     * 请求失败
     */
    int TP_FAILED = 500;


    /**
     * 非法请求
     */
    int ILLEGAL_REQUEST = 401;


    /**
     * 有权限
     */
    int TP_OK_PERMISSON = 2000;

    /**
     * 无权限
     */
    int TP_FAILED_PERMISSON = 5000;

    /**
     * token有效
     */
    int TP_OK_TOKEN = 2001;

    /**
     * token无效
     */
    int TP_FAILED_TOKEN = 5001;


}
