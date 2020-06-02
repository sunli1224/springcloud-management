package com.manager.search.controller;

import com.manager.domaindto.EmployeeDto;
import com.manager.search.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sunli
 * @date 2020/5/5 5:06
 */
@RestController
@RequestMapping("/empSearchService")
public class EmpSearchController {

    @Autowired
    private EmpService empService;

    @GetMapping("/searchNum/{empNum}")
    public List<EmployeeDto> searchEmpListByEmpNum(@PathVariable("empNum")String empNum) {
        return empService.SearchEmpInfoByEmpNum(empNum);
    }

    @GetMapping("/searchName/{empName}")
    public List<EmployeeDto> searchEmpListByEmpName(@PathVariable("empName")String empName) {
        return empService.SearchEmpInfoByEmpName(empName);
    }
}
