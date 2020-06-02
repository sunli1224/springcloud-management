package com.manager.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.manager.mapper.TbRoleMapper;
import com.manager.service.TbRoleService;
/**
*@author sunli
* @date 2020/3/24 0:50
*/  
@Service
public class TbRoleServiceImpl implements TbRoleService{

    @Resource
    private TbRoleMapper tbRoleMapper;

}
