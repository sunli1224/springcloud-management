package com.manager.provider.service;



import com.manager.domain.Student;
import com.manager.domaindto.StudentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
*@author sunli
* @date 2020/3/15 15:50
*/  
public interface StudentService{


    Boolean addOneService(Student student) throws Exception;
    /**
     * 批量插入
     * @param path 文件地址
     * @return 是否插入成功
     */
    Boolean addAllService(String path) ;

    /**
     * 通过学号查询用户信息
     * @param stuNumber 学号
     * @return 查询信息
     * @throws Exception
     */
    StudentDto selectOneInfoByStuNumber(@Param("stuNumber")String stuNumber) throws Exception;

    /**
     * 查询所有学生信息
     * @return List<Student>
     * @throws Exception
     */
    List<Student> selectAllStudent() throws Exception;

    /**
     * 查询学生根据学生学号
     * @param stuNumber 学号
     * @return
     * @throws Exception
     */
    Student selectOneStudentByStuNumber(String stuNumber) throws Exception;

    /**
     * 获取学生所有信息包括宿舍号和楼号
     * @return 学生集合
     * @throws Exception
     */
    List<StudentDto> selectAllStudentList() throws Exception;

    /**
     * 分页服务
     * @param ids 第几页
     * @return 分页集成数据
     * @throws Exception
     */
    Map<String,Object> getPagingLock(Integer ids) throws Exception;

    /**
     * 根据学号
     * 进行模糊查询
     * 根据条件查询学生数据集合
     * @return 根据条件返回学生数据集合
     * @throws Exception
     */
    List<StudentDto> getStudnentListByStuNumber(String stuNumber) throws Exception;

    /**
     * 根据学生姓名
     * 根据条件查询学生数据结构
     * @param stuName 学生姓名
     * @return 根据条件返回数据结构
     * @throws Exception
     */
    List<StudentDto> getStudnentListBystuName(String stuName) throws Exception;

    /**
     * 选择学号和学生姓名进行模糊查询
     * @param stuNumber 学号
     * @param stuName 学生姓名
     * @return 学生数据集合
     * @throws Exception
     */
    Map<String, Object> getStudentListChooseException(String stuNumber, String stuName) throws Exception;



    /**
     * 根据学生学号删除对应的学生
     *  字段 stu_del
     *  0 未删除
     *  1 删除
     * @param stuNumber 学生学号
     * @return 对学生数据进行软删除
     * @throws Exception
     */
    Boolean deleteStudent(String stuNumber) throws Exception;


    /**
     * 单个删除服务
     * @param stuNumber 学号
     * @return 是否成功
     * @throws Exception
     */
    Boolean deleteStudentService(String stuNumber) throws Exception;



    /**
     * 批量删除学生服务
     * @param studentNumberList 学生学号集合
     * @return 对学生数据进行软删除
     * @throws Exception
     */
    Boolean deleteAllStudentListService(List<String> studentNumberList)throws Exception;


    /**
     * 根据不同的条件
     * 单个更新学生数据
     * @return 是否执行成功
     * @throws Exception
     */
    Boolean updateOneStudent(StudentDto studentDto) throws Exception;

    /**
     * 根据不同的条件
     * 单个更新学生数据服务
     * @return 是否执行成功
     * @throws Exception
     */
    Boolean updateStudentInfoByIdService(StudentDto studentDto) throws Exception;

}
