package com.manager.search.service;

import com.manager.domaindto.DormitoryexchangerecordDto;

import java.util.List;

/**
 * @author sunli
 * @date 2020/5/8 3:16
 */
public interface DorService {

    /**
     * 根据学号查询查询
     * @param stuNum 学号
     * @return 结果
     */
    public List<DormitoryexchangerecordDto> selectInfoByStuNumber(String stuNum);

    /**
     * 根据学生姓名查询
     * @param stuName 学生姓名
     * @return 结果
     */
    public List<DormitoryexchangerecordDto> selectInfoByStuName(String stuName);
}
