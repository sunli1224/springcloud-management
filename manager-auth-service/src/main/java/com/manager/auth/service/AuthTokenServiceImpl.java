package com.manager.auth.service;

import com.manager.commons.TokenUtils;
import org.springframework.stereotype.Service;

/**
 * token服务
 * @author sunli
 * @date 2020/3/24 1:01
 */
@Service
public class AuthTokenServiceImpl implements AuthTokenService {

    @Override
    public String createToken(String username) throws Exception {
        return TokenUtils.createToken(username);
    }

    @Override
    public Boolean parseToken(String token) throws Exception {
        return TokenUtils.parseJwtToken(token);
    }
}
