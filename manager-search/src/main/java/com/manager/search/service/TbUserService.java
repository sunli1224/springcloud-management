package com.manager.search.service;

import com.manager.domaindto.UserDto;

import java.util.List;

/**
 * @author sunli
 * @date 2020/5/12 21:24
 */
public interface TbUserService {

    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return 用户集合
     * @throws Exception
     */
    public List<UserDto> selectUserInfoByUserName(String username);
}
