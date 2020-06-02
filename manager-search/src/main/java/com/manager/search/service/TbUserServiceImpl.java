package com.manager.search.service;

import com.manager.commons.HttpStatus;
import com.manager.domaindto.UserDto;
import com.manager.exception.AuthException;
import com.manager.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限管理搜索服务
 * @author sunli
 * @date 2020/5/12 21:25
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public List<UserDto> selectUserInfoByUserName(String username) {
        try {
            if (username != null) {
                return tbUserMapper.selectUserInfoByUserName(username);
            }
        } catch (Exception e) {
            throw new AuthException(HttpStatus.TP_FAILED,"搜索失败");
        }
        throw new AuthException(HttpStatus.TP_FAILED,"搜索失败");
    }
}
