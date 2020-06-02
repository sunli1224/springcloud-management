package com.manager.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.manager.mapper.StudentMapper;
import com.manager.service.StudentService;

/**
 * @author sunli
 * @date 2020/3/18 18:13
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

}

