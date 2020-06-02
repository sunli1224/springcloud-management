package com.manager.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.manager.mapper.EmployeeMapper;
import com.manager.service.EmployeeService;

/**
 * @author sunli
 * @date 2020/3/15 15:50
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

}


