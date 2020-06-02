package com.manager.commons;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * BCryptPasswordEncoder
 * 加密工具类
 * @author sunli
 * @date 2020/3/24 15:33
 */
public class bCryptPasswordUtils {


    /**
     * 盐值
     */
    private static int strength = 16;

    /**
     * 自定义盐值加密
     * @param strength 盐值
     * @param password 密码
     * @return 密码密文
     */
    public static String encode(int strength,String password) {
        return new BCryptPasswordEncoder(strength).encode(password);
    }

    /**
     * 密码加密
     * @param password 密码
     * @return 密码密文
     */

    public static String encode(String password) {
        return new  BCryptPasswordEncoder(strength).encode(password) ;
    }

    /**
     * 判断密码是否相同
     * @param pass 明文
     * @param mixPass 密文
     * @return true，false
     */
    public static Boolean matchers(String pass, String mixPass) {
        return new BCryptPasswordEncoder(strength).matches(pass, mixPass);
    }
}
