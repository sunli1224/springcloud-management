package com.manager.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.manager.mapper.FloorMapper;
import com.manager.service.FloorService;

/**
 * @author sunli
 * @date 2020/3/15 15:50
 */
@Service
public class FloorServiceImpl implements FloorService {

    @Resource
    private FloorMapper floorMapper;

}

