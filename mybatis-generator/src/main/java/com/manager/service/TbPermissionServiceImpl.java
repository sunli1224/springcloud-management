package com.manager.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.manager.mapper.TbPermissionMapper;
import com.manager.service.TbPermissionService;
/**
*@author sunli
* @date 2020/5/9 16:39
*/  
@Service
public class TbPermissionServiceImpl implements TbPermissionService{

    @Resource
    private TbPermissionMapper tbPermissionMapper;

}
