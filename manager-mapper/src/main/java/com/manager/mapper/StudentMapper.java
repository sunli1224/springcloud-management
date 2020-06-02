package com.manager.mapper;

import basemapper.BaseMapper;
import com.manager.domain.Student;
import com.manager.domain.StudentExtend;
import com.manager.domaindto.StudentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
*@author sunli
* @date 2020/3/15 15:50
*/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    /**
     * 包含楼号
     * 查询所有学生信息
     * @return List<Student>
     * @throws Exception
     */
    List<StudentExtend> getAllByStuFloorId() throws Exception;

    /**
     * 包含宿舍号、楼号
     * 查询学生根据学生学号
     * 当学号学号为空时查询所有
     * @param stuNumber 学号
     * @return Student
     * @throws Exception
     */
    Student selectOneStudentByStuNumber( @Param("stuNumber") String stuNumber) throws Exception;

    /**
     * 查询学生根据学生学号
     * 当学号学号为空时查询所有
     * @return List<Student> 学生集合
     * @throws Exception
     */
    List<StudentDto> selectAllStudentList() throws Exception;

    /**
     * 根据学号
     * 进行模糊查询
     * 根据条件查询学生数据集合
     * @return 根据条件返回学生数据集合
     * @throws Exception
     */
    List<StudentDto> getStudnentListByStuNumber(@Param("stuNumber") String stuNumber) throws Exception;

    /**
     * 根据学生姓名
     * 进行模糊查询
     * @param stuName 学生姓名
     * @return 根据条件返回学生数据集合
     * @throws Exception
     */
    List<StudentDto> getStudnentListByStuName(@Param("stuName") String stuName) throws Exception;


    /**
     * 根据学生学号删除对应的学生
     *  字段 stu_del
     *  0 未删除
     *  1 删除
     * @param stuNumber 学生学号
     * @return 对学生数据进行软删除
     * @throws Exception
     */
    Boolean deleteStudent(@Param("stuNumber") String stuNumber) throws Exception;

    /**
     * 根据不同的条件
     * 单个更新学生数据
     * @return 是否执行成功
     * @throws Exception
     */
    Boolean updateOneStudent(StudentDto studentDto) throws Exception;

    /**
     * 根据学号更新学生宿舍楼宇的信息
     * @param stuNum 学号
     * @param floorName 楼宇名
     * @param hosNum 宿舍名
     * @return 是否更新成功
     * @throws Exception
     */
    Boolean updateStuInfoByStuNum(@Param("stuNum") String stuNum,@Param("floorName") String floorName,@Param("hosNum")String hosNum)throws Exception;


    /**
     * 通过学号查询用户信息
     * @param stuNumber 学号
     * @return 查询信息
     * @throws Exception
     */
    StudentDto selectOneInfoByStuNumber(@Param("stuNumber")String stuNumber) throws Exception;
}
