package com.manager.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.manager.mapper.DormitoryexchangerecordMapper;
import com.manager.service.DormitoryexchangerecordService;

/**
 * @author sunli
 * @date 2020/3/15 15:50
 */
@Service
public class DormitoryexchangerecordServiceImpl implements DormitoryexchangerecordService {

    @Resource
    private DormitoryexchangerecordMapper dormitoryexchangerecordMapper;

}

