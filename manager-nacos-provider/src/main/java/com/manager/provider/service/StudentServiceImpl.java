package com.manager.provider.service;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.commons.ExcelUtil;
import com.manager.commons.HttpStatus;
import com.manager.commons.JsonUtil;
import com.manager.commons.PageHelperUtils;
import com.manager.domain.Student;
import com.manager.domaindto.StudentDto;
import com.manager.excelbean.StudentExcelBean;
import com.manager.exception.PageHelperException;
import com.manager.exception.studetException;
import com.manager.mapper.HostelMapper;
import com.manager.mapper.StudentMapper;
import org.omg.CORBA.UserException;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import org.springframework.cloud.stream.messaging.Source;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学生管理服务
*@author sunli
* @date 2020/3/15 15:50
*/  
@Service
public class StudentServiceImpl implements StudentService{

    @Resource
    private HostelMapper hostelMapper;

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private HostelService hostelService;

    @Resource
    private floorService floorService;


    @Override
    public Boolean addOneService(Student student) throws Exception {
        // Example e = new Example(Student.class);
        return studentMapper.insert(student) == 1;
    }

    @Override
    public Boolean addAllService(String path) {
        try {
            InputStream inputStream=new FileInputStream(path);
            //读入文件，每一行对应一个 Model，获取 Model 列表
            List<StudentExcelBean> objectList = ExcelUtil.readExcelWithModel(inputStream, StudentExcelBean.class, ExcelTypeEnum.XLSX);
            for(StudentExcelBean item: objectList) {
                this.addOneService(new Student(null,item.getStuNum(),item.getStuName(),item.getStuSex(),item.getStuProfession(),item.getStuClass(),item.getStuSess(),item.getStuPhoneNumber(),hostelMapper.selectHostelFloorInfoByHosId(null,item.getStuHos(),item.getStuFloor()).getHosId(),floorService.getInfoPrimaryKey(item.getStuFloor()),0));
                    hostelMapper.updateAddHosNum(item.getStuFloor(), item.getStuHos());
//                hostelMapper.updateAddHosNum(item.getStuFloor(), item.getStuHos());
//                System.out.println(StudentExcelBean);
            }
            File file = new File(path);
            if (file.exists()) {
                file.delete();
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new studetException(Integer.toString(HttpStatus.TP_FAILED),"请求超时");
        }
    }

    @Override
    public StudentDto selectOneInfoByStuNumber(String stuNumber) throws Exception {
        return studentMapper.selectOneInfoByStuNumber(stuNumber);
    }

    /**
     * 查询所有学生信息
     * @return List<Student>
     * @throws Exception
     */
    @Override
    public List<Student> selectAllStudent() {
        return studentMapper.selectAll();
    }

    /**
     * 当学号学号为空时查询所有
     * 查询学生根据学生学号
     * @param stuNumber 学号
     * @return Student
     * @throws Exception
     */
    @Override
    public Student selectOneStudentByStuNumber(String stuNumber) throws Exception {
        return studentMapper.selectOneStudentByStuNumber(stuNumber);
    }

    /**
     * 获取学生所有信息包括宿舍号和楼号
     * @return 学生集合
     * @throws Exception
     */
    @Override
    public List<StudentDto> selectAllStudentList() throws Exception {
        return studentMapper.selectAllStudentList();
    }


    /**
     * 分页服务
     * @param ids 第几页
     * @return 每页的数据
     * @throws Exception
     */
    @Override
    public Map<String,Object> getPagingLock(Integer ids) throws Exception {
        if (ids != null) {
            HashMap<String,Object> map = new HashMap<>();
            PageHelper.startPage(ids,12);
            List<StudentDto> studentList = studentMapper.selectAllStudentList();
            PageInfo page = new PageInfo(studentList);
            // 查询的所有数据
            map.put("recordNum",studentList.size());
            // 当前请求第几页
            map.put("pageNum",page.getPageNum());
            // 总页数14】
            map.put("pageSize",page.getPageSize());
            // 首页页数
            map.put("isFirstPage",page.isIsFirstPage());
            // 尾页页数
            map.put("isLastPage",page.isIsLastPage());
            // 当前页数的数据
            map.put("stuList",studentList);
            return map;
        }
        throw new PageHelperException(500,"请求失败");
    }


    /**
     * 根据学生学号
     * 进行模糊查询
     * @param stuNumber 学生学号
     * @return 返回学生数据结构
     * @throws Exception
     */
    @Override
    public List<StudentDto> getStudnentListByStuNumber(String stuNumber) throws Exception {
        return studentMapper.getStudnentListByStuNumber(stuNumber);
    }

    /**
     * 根据学生姓名
     * 进行模糊查询
     * 根据条件查询学生数据集合
     * @return 根据条件返回学生数据集合
     * @throws Exception
     */
    @Override
    public List<StudentDto> getStudnentListBystuName(String stuName) throws Exception {
        return studentMapper.getStudnentListByStuName(stuName);
    }

    /**
     * 选择学号和学生姓名进行模糊查询
     * @param stuNumber 学号
     * @param stuName 学生姓名
     * @return 学生数据集合
     * @throws Exception
     */
    @Override
    public Map<String, Object> getStudentListChooseException(String stuNumber, String stuName) throws Exception {
        Map<String,Object> map = new HashMap<>();
        if (stuNumber == null) {
            map.put("stuList",this.getStudnentListBystuName(stuName));
            return map;
        }
        if (stuName == null) {
            map.put("stuList",this.getStudnentListByStuNumber(stuNumber));
            return map;
        }
        throw new studetException("500","请求超时");
    }


    /**
     * 根据学生学号删除对应的学生
     *  字段 stu_del
     *  0 未删除
     *  1 删除
     * @param stuNumber 学生学号
     * @return 对学生数据进行软删除
     * @throws Exception
     */
    @Override
    public Boolean deleteStudent(String stuNumber) throws Exception {
        return studentMapper.deleteStudent(stuNumber);
    }


    /**
     * 单个删除服务
     * @param stuNumber 学号
     * @return 是否成功
     * @throws Exception
     */
    @Override
    public Boolean deleteStudentService(String stuNumber) {
        if (stuNumber != null) {
            try {
                StudentDto stuInfo = this.selectOneInfoByStuNumber(stuNumber);
                hostelMapper.updateDelHosNum(stuInfo.getFloorName(), stuInfo.getHosNum());
                return this.deleteStudent(stuNumber);
            } catch (Exception e) {
                throw new studetException(Integer.toString(HttpStatus.TP_FAILED),"删除失败");
            }
        }
       return false;
    }


    /**
     * 批量删除学生服务
     * @param studentNumberList 学生学号集合
     * @return 对学生数据进行软删除
     * @throws Exception
     */
    @Override
    public Boolean deleteAllStudentListService(List<String> studentNumberList) throws Exception {
        if (studentNumberList != null) {
            studentNumberList.forEach(item -> {
                try {
                    this.deleteStudent(item);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            return true;
        }
        throw new studetException("500","请求失败");
    }

    /**
     * 根据不同的条件
     * 单个更新学生数据
     * @return 是否执行成功
     * @throws Exception
     */
    @Override
    public Boolean updateOneStudent(StudentDto studentDto) throws Exception {
        return studentMapper.updateOneStudent(studentDto);
    }

    /**
     * 根据不同的条件
     * 单个更新学生数据服务
     * @return 是否执行成功
     * @throws Exception
     */
    @Override
    public Boolean updateStudentInfoByIdService(StudentDto studentDto) throws Exception {
        if (studentDto.getStuId() != null) {
            return this.updateOneStudent(studentDto);
        }
       return false;
    }


}
