package com.manager.search.service;

import com.manager.commons.HttpStatus;
import com.manager.domaindto.EmployeeDto;
import com.manager.exception.EmployeeException;
import com.manager.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author sunli
 * @date 2020/5/5 5:08
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDto> SearchEmpInfoByEmpName(String empName) {
        try {
            return  employeeMapper.selectEmpInfoByEmpName(empName);
        } catch (Exception e) {
            throw new  EmployeeException(HttpStatus.TP_FAILED,"查询失败");
        }
    }

    @Override
    public List<EmployeeDto> SearchEmpInfoByEmpNum(String empNum) {
        try {
            return  employeeMapper.selectEmpInfoByEmpNum(empNum);
        } catch (Exception e) {
            throw new  EmployeeException(HttpStatus.TP_FAILED,"查询失败");
        }
    }
}
