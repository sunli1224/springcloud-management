package com.manager.auth.service;

/**
 * Token服务
 * @author sunli
 * @date 2020/3/24 0:58
 */
public interface AuthTokenService {
    /**
     * 根据用户名生成token
     * @param username 用户名
     * @return token
     * @throws Exception
     */
    public String createToken(String username) throws Exception;

    /**
     * 解析token
     * @return token是否被解析
     * @throws Exception
     */
    public Boolean parseToken(String token) throws Exception;
}
