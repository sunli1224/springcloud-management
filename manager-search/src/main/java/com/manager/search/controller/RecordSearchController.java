package com.manager.search.controller;

import com.manager.commons.JsonResponse;
import com.manager.domaindto.RecordDto;
import com.manager.search.service.RecordSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sunli
 * @date 2020/5/7 15:29
 */
@RestController
@RequestMapping("/RecordSearch")
public class RecordSearchController {

    @Autowired
    private RecordSearchService recordSearchService;

    @GetMapping("/searchStuNum/{stuNumber}")
    public List<RecordDto> searchStuNumberController(@PathVariable("stuNumber")String stuNumber) {
        return recordSearchService.searchRecordByStuNumber(stuNumber);
    }

    @GetMapping("/searchStuName/{stuName}")
    public List<RecordDto> searchStuNameController(@PathVariable("stuName")String stuName) {
        return recordSearchService.searchRecordByStuName(stuName);
    }
}
