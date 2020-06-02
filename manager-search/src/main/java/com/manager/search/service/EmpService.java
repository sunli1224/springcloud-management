package com.manager.search.service;

import com.manager.domaindto.EmployeeDto;

import java.util.List;
import java.util.Map;

/**
 * @author sunli
 * @date 2020/5/5 5:08
 */
public interface EmpService {
    /**
     * 通过员工姓名查询
     * @param empName 员工姓名
     * @return 员工信息集合
     */
    public List<EmployeeDto> SearchEmpInfoByEmpName(String empName);

    /**
     * 通过员工工号查询
     * @param empNum 员工工号
     * @return 员工信息集合
     */
    public List<EmployeeDto> SearchEmpInfoByEmpNum(String empNum);
}
