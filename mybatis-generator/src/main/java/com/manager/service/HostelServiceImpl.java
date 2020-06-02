package com.manager.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.manager.mapper.HostelMapper;
import com.manager.service.HostelService;

/**
 * @author sunli
 * @date 2020/3/17 16:25
 */
@Service
public class HostelServiceImpl implements HostelService {

    @Resource
    private HostelMapper hostelMapper;

}


