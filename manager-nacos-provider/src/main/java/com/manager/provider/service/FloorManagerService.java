package com.manager.provider.service;

import com.manager.domain.Employee;
import com.manager.domaindto.EmployeeDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author sunli
 * @date 2020/4/22 14:54
 */
public interface FloorManagerService {

    /**
     * 楼宇管理员分页服务
     * @return 楼宇管理员map集合
     */
    public Map<String,Object> selectAllFloorManagerInfoPaging(Integer ids);

    /**
     * 查询所有楼宇管理员信息
     * @return 查询楼宇管理员信息
     * @throws Exception
     */
    List<EmployeeDto> selectAllFloorManagerInfoList() throws Exception;

    /**
     * 查询所有楼宇管理员信息服务
     * @return 包装所有楼宇信息map集合
     * @throws Exception
     */
    Map<String,Object> getAllFloorInfoMnangerList() throws Exception;

    /**
     * 删除单个楼宇管理员信息
     * @param empId 员工id
     * @return 是否删除成功
     * @throws Exception
     */
    Boolean deleteOneFloorManagerInfo(Integer empId) throws Exception;

    /**
     * 删除单个楼宇管理员信息服务
     * @param empId 员工id
     * @return 是否正确删除
     * @throws Exception
     */
    Boolean deleteOneFloorMannagerService(Integer empId) throws Exception;

    /**
     * 批量删除楼宇管理员信息服务
     * @param empIdList 员工id数组集合
     * @return 是否正确删除
     * @throws Exception
     */
    Boolean deleteSomeOfFloorManagerService(List<Integer> empIdList) throws Exception;

    /**
     * 插入一条数据
     * @param employee 员工对象
     * @return 是否插入成功
     * @throws Exception
     */
    Boolean insertOneFloorManagerInfo(Employee employee) throws Exception;


    /**
     * 添加一条楼宇管理员服务
     * @param employee 员工dto
     * @return 插入是否成功
     */
    Boolean insertOneFloorManagerInfoService(EmployeeDto employee) throws Exception;


    /**
     * 查询手机或者员工职工号
     * @param empNum 员工学号
     * @param empPhone 员工手机号
     * @return 查询结果集数量
     * @throws Exception
     */
    Integer selectFloorManagerInfoSame( String empNum,String empPhone) throws Exception;

    /**
     * 更新楼宇信息
     * @param employee 更新楼宇管理员对象
     * @return 是否更新成功
     * @throws Exception
     */
    Boolean updateFloorManagerInfoByException(EmployeeDto employee) throws Exception;

    /**
     * 更新楼宇信息服务
     * @param employee 更新楼宇管理员对象
     * @return 是否更新成功
     */
    Boolean updateFloorManagerInfoByExceptionService(EmployeeDto employee);

}
