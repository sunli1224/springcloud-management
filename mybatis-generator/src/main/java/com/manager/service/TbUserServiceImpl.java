package com.manager.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.manager.mapper.TbUserMapper;
import com.manager.service.TbUserService;
/**
*@author sunli
* @date 2020/5/9 16:39
*/  
@Service
public class TbUserServiceImpl implements TbUserService{

    @Resource
    private TbUserMapper tbUserMapper;

}
