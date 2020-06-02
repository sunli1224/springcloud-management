package com.manager.search.controller;

import com.manager.domaindto.floorDto;
import com.manager.search.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sunli
 * @date 2020/5/5 1:46
 */
@RestController
@RequestMapping("/floorSearchService")
public class FloorSearchController {

    @Autowired
    private FloorService floorService;

    @GetMapping("/searchFloor/{floorName}")
    public List<floorDto> searchFloorInfoByFloorName(@PathVariable("floorName") String floorName) {
        return floorService.searchFloorInfoByFloorName(floorName);
    }
}
