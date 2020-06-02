package com.manager.auth.service;

import com.manager.commons.HttpStatus;
import com.manager.commons.bCryptPasswordUtils;
import com.manager.domain.TbUser;
import com.manager.domaindto.UserDto;
import com.manager.exception.userException;
import com.manager.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户注册中心服务
 * @author sunli
 * @date 2020/3/24 1:01
 */
@Service
public class UserDatailServiceImpl implements UserDatailService {

    /**
     * 判断是否是用户服务
     * @param username 用户名
     * @param password 密码
     * @return 返回信息
     */
    @Override
    public Map<String,Object> judgeUserReal(String username, String password) throws Exception {
        Map<String,Object> tokenMap = new HashMap<>();
            TbUser user = this.getUserName(username);
                if (user != null) {
                    if (user.getUsername().equals(username)) {
                        if (bCryptPasswordUtils.matchers(password,user.getPassword())) {
                            // Map<String,Object> map = this.getUserAndRolePemisson(username);
                            // tokenMap.put("role",map.get("role"));
                            // tokenMap.put("username",username);
                            tokenMap.put("userInfo",userMapper.getUserInfoByUserName(username));
                            tokenMap.put("token",authTokenService.createToken(username));
                            // 远程调用redis缓存服务
                            redisService.save(tokenMap);
                            return tokenMap;
                        } else {
                            throw new userException(Integer.toString(HttpStatus.TP_FAILED),"密码错误","password");
                        }
                    }
                } else {
                    throw new userException(Integer.toString(HttpStatus.TP_FAILED),"用户名错误","username");
                }
        throw new userException(Integer.toString(HttpStatus.TP_FAILED),"请求错误","network");
    }

    @Override
    public TbUser getUserName(String username) {
        Example e = new Example(TbUser.class);
        e.createCriteria().andEqualTo("username",username);
        return userMapper.selectOneByExample(e);
    }

    @Override
    public List<TbUser> selectOneUserByUserName(String username) throws Exception {
        return userMapper.selectOneUserByUserName(username);
    }

    @Override
    public Map<String, Object> getUserAndRolePemisson(String username) {
        List<TbUser> userList = null;
        Map<String,Object> map = new HashMap<>();
        ArrayList<String> roleList = new ArrayList<>();
        ArrayList<String> tbPermissionList = new ArrayList<>();
        try {
            userList = this.selectOneUserByUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (userList != null) {
            userList.forEach(item -> {
                if (item.getRoleList() != null) {
                    item.getRoleList().forEach(it -> {
                        roleList.add(it.getEnname());
                        if (it.getPermissionList() != null) {
                            it.getPermissionList().forEach(peItem -> {
                                tbPermissionList.add(peItem.getName());
                            });
                        }
                    });
                }
            });
        }

        map.put("role",roleList);
        map.put("pemisson",tbPermissionList);

        return map;
    }

    @Override
    public UserDto selectOneByUserName(String username) throws Exception {
        return userMapper.selectOneByUserName(username);
    }

    @Autowired
    private AuthTokenService authTokenService;

    @Autowired
    private TbUserMapper userMapper;

    @Autowired
    private redisService redisService;

}
