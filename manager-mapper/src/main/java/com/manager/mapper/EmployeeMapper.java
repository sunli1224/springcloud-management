package com.manager.mapper;


import basemapper.BaseMapper;
import com.manager.domain.Employee;
import com.manager.domaindto.EmployeeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
*@author sunli
* @date 2020/3/15 15:50
*/
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

    /**
     * 查询所有楼宇管理员信息
     * @return 查询楼宇管理员信息
     * @throws Exception
     */
    List<EmployeeDto> selectAllFloorManagerInfoList() throws Exception;


    /**
     * 删除单个楼宇管理员信息
     * @param empId 员工id
     * @return 是否删除成功
     * @throws Exception
     */
    Boolean deleteOneFloorManagerInfo(@Param("empId") Integer empId) throws Exception;


    /**
     * 插入一条数据
     * @param employee 员工对象
     * @return 是否插入成功
     * @throws Exception
     */
    Boolean insertOneFloorManagerInfo(Employee employee) throws Exception;


    /**
     * 查询手机或者员工职工号
     * @param empNum 员工学号
     * @param empPhone 员工手机号
     * @return 查询结果集数量
     * @throws Exception
     */
    Integer selectFloorManagerInfoSame(@Param("empNum") String empNum,@Param("empPhone") String empPhone) throws Exception;


    /**
     * 更新楼宇信息
     * @param employee 更新楼宇管理员对象
     * @return 是否更新成功
     * @throws Exception
     */
    Boolean updateFloorManagerInfoByException(EmployeeDto employee) throws Exception;

    /**
     * 根据员工的姓名查询
     * @param empName 姓名
     * @return 员工信息集合
     * @throws Exception
     */
    List<EmployeeDto> selectEmpInfoByEmpName(@Param("empName") String empName) throws Exception;

    /**
     * 根据员工的工号查询
     * @param empNum 工号
     * @return 员工信息集合
     * @throws Exception
     */
    List<EmployeeDto> selectEmpInfoByEmpNum(@Param("empNum") String empNum) throws Exception;
}