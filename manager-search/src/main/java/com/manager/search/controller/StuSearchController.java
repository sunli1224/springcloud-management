package com.manager.search.controller;

import com.manager.domaindto.StudentDto;
import com.manager.search.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生搜索服务
 * @author sunli
 * @date 2020/5/2 14:16
 */
@RestController
@RequestMapping("/stuSearch")
public class StuSearchController {

    @Autowired
    private StuService stuService;

    @GetMapping("/stuNumber/{stuNumber}")
    public List<StudentDto> SearchStuInfoByStudentNumber(@PathVariable("stuNumber") String stuNumber) {
        return stuService.getStuListByStudentNumber(stuNumber);
    }

    @GetMapping("/stuName/{stuName}")
    public List<StudentDto> SearchStuInfoByStudentName(@PathVariable("stuName") String stuName) {
        return stuService.getStudentByStudentName(stuName);
    }
}
