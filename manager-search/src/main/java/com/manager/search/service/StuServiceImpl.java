package com.manager.search.service;

import com.manager.commons.HttpStatus;
import com.manager.domaindto.StudentDto;
import com.manager.exception.studetException;
import com.manager.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 搜索服务
 * @author sunli
 * @date 2020/5/2 13:56
 */
@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 根据学号查询相关信息
     * 模糊查询
     * @param studentNumber 学号
     * @return 返回学生信息集合
     */
    @Override
    public List<StudentDto> getStuListByStudentNumber(String studentNumber){
        if (studentNumber != null) {
            try {
                return studentMapper.getStudnentListByStuNumber(studentNumber);
            } catch (Exception e) {
                throw new studetException(Integer.toString(HttpStatus.TP_FAILED),"学生搜索服务请求失败");
            }
        }
        throw new studetException(Integer.toString(HttpStatus.TP_FAILED),"学生搜索服务请求失败");
    }

    /**
     * 根据学生姓名查询相关信息
     * 模糊查询
     * @param studentName 学生姓名
     * @return 返回学生信息集合
     */
    @Override
    public List<StudentDto> getStudentByStudentName(String studentName) {
        if (studentName != null) {
            try {
                return studentMapper.getStudnentListByStuName(studentName);
            } catch (Exception e) {
                throw new studetException(Integer.toString(HttpStatus.TP_FAILED),"学生搜索服务请求失败");
            }
        }
        throw new studetException(Integer.toString(HttpStatus.TP_FAILED),"学生搜索服务请求失败");
    }


}
