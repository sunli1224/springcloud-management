package com.manager.search.service;

import com.manager.commons.HttpStatus;
import com.manager.domaindto.floorDto;
import com.manager.exception.PageHelperException;
import com.manager.mapper.FloorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * 楼宇搜索服务
 * @author sunli
 * @date 2020/5/5 1:32
 */
@Service
public class FloorServiceImpl implements FloorService {

    @Autowired
    private FloorMapper floorMapper;

    @Override
    public List<floorDto> searchFloorInfoByFloorName(String floorName) {
        try {
            return floorMapper.selectFloorListByFloorName(floorName);
        } catch (Exception e) {
            throw new PageHelperException(HttpStatus.TP_FAILED,"请求失败");
        }
    }
}
