package com.manager.search.controller;

import com.manager.commons.JsonResponse;
import com.manager.domaindto.DormitoryexchangerecordDto;
import com.manager.search.service.DorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sunli
 * @date 2020/5/8 3:15
 */
@RestController
@RequestMapping("/dorSearchService")
public class DorSearchController {
    @Autowired
    private DorService dorService;

    /**
     * 搜索服务
     * @param stuName 学生姓名
     * @return 搜索结果
     */
    @GetMapping("/searchName/{stuName}")
    public List<DormitoryexchangerecordDto> searchByStuNameController(@PathVariable("stuName")String stuName) {
        return dorService.selectInfoByStuName(stuName);
    }

    /**
     * 搜索服务
     * @param stuNum 学号
     * @return 搜索结果
     */
    @GetMapping("/searchNum/{stuNum}")
    public List<DormitoryexchangerecordDto> searchByStuNumController(@PathVariable("stuNum")String stuNum) {
        return dorService.selectInfoByStuNumber(stuNum);
    }
}
