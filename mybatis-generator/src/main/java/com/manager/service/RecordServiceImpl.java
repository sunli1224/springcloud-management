package com.manager.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.manager.mapper.RecordMapper;
import com.manager.service.RecordService;

/**
 * @author sunli
 * @date 2020/3/15 15:50
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Resource
    private RecordMapper recordMapper;

}

