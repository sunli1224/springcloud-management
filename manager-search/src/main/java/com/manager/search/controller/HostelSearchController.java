package com.manager.search.controller;

import com.manager.domaindto.HostelDto;
import com.manager.search.service.HostelSearchService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sunli
 * @date 2020/5/7 20:41
 */
@RestController
@RequestMapping("/hostelSearchService")
public class HostelSearchController {

    @Autowired
    private HostelSearchService hostelSearchService;

    @GetMapping("/searchHosNum/{hosNum}")
    public List<HostelDto> searchHostelInfoByHostelNum(@PathVariable("hosNum") String hosNum) {
        return hostelSearchService.searchHostelInfoByHostelNum(hosNum);
    }

    @GetMapping("/searchFloorName/{floorName}")
    public List<HostelDto> searchHostelInfoByFloorName(@PathVariable("floorName")String floorName) {
        return hostelSearchService.searchHostelInfoByFloorName(floorName);
    }

    @GetMapping("/searchHosByFloor/{floorName}")
    public List<HostelDto> searchHostelInfo(@PathVariable("floorName")String floorName) {
        return hostelSearchService.selectHosByFloorName(floorName);
    }

    @GetMapping("/searchRemaingHosByFloor/{floorName}")
    public List<HostelDto> searchRemaingHosController(@PathVariable("floorName") String floorName) {
        return hostelSearchService.selectRemaingHosByFloorName(floorName);
    }
}
