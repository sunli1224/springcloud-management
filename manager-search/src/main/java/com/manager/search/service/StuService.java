package com.manager.search.service;

import com.manager.domaindto.StudentDto;

import java.util.List;

/**
 * 学生搜索服务
 * @author sunli
 * @date 2020/5/2 13:55
 */
public interface StuService {
    /**
     * 根据学号查询相关信息
     * 模糊查询
     * @param studentNumber 学号
     * @return 返回学生信息集合
     */
    public List<StudentDto> getStuListByStudentNumber(String studentNumber);

    /**
     * 根据学生姓名查询相关信息
     * 模糊查询
     * @param studentName 学生姓名
     * @return 返回学生信息集合
     */
    public List<StudentDto> getStudentByStudentName(String studentName);
}
