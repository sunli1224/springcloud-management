package com.manager.auth.service;

import com.manager.domain.TbUser;
import com.manager.domaindto.UserDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author sunli
 * @date 2020/3/24 1:00
 */
public interface UserDatailService {
    /**
     * 判断是否是用户服务
     * @param username 用户名
     * @param password 密码
     * @return 返回信息
     * @throws Exception
     */
    public Map<String,Object> judgeUserReal(String username, String password) throws Exception;

    /**
     * 查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    public TbUser getUserName(String username) throws Exception;

    /**
     *  查询用户的角色和权限
     * @param username 用户名
     * @return
     * @throws Exception
     */
    public List<TbUser> selectOneUserByUserName(String username) throws Exception;

    /**
     * 整合用户的角色和权限
     * @param username 用户名
     * @return 返回用户的角色和权限map集合
     * @throws Exception
     */
    public Map<String,Object> getUserAndRolePemisson(String username) throws Exception;

    /**
     * 查询用户信息
     * @param username 用户名
     * @return 用户信息
     * @throws Exception
     */
    public UserDto selectOneByUserName(String username)throws Exception;
}
