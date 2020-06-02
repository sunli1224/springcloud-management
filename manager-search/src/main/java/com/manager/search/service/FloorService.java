package com.manager.search.service;

import com.manager.domaindto.floorDto;

import java.util.List;

/**
 * 楼宇管理搜索服务
 * @author sunli
 * @date 2020/5/5 1:30
 */
public interface FloorService {

    /**
     * 模糊查询楼宇相关信息
     * @param floorName 楼宇名
     * @return 楼宇集合
     */
    public List<floorDto> searchFloorInfoByFloorName(String floorName);
}
