package com.manager.provider.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.commons.HttpStatus;
import com.manager.domain.Employee;
import com.manager.domaindto.EmployeeDto;
import com.manager.exception.EmployeeException;
import com.manager.exception.PageHelperException;
import com.manager.mapper.EmployeeMapper;
import com.manager.mapper.FloorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunli
 * @date 2020/4/22 14:55
 */
@Service
public class FloorManagerServiceImpl implements FloorManagerService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private FloorMapper floorMapper;


    /**
     * 楼宇管理员分页服务
     * @return 楼宇管理员map集合
     */
    @Override
    public Map<String, Object> selectAllFloorManagerInfoPaging(Integer ids) {
        List<EmployeeDto> employeeDtoList = null;
        HashMap<String,Object> map = new HashMap<>();
        try {
            PageHelper.startPage(ids, 12);
            employeeDtoList = employeeMapper.selectAllFloorManagerInfoList();
            PageInfo page = new PageInfo(employeeDtoList);
            // 当前请求第几页
            map.put("pageNum",page.getPageNum());
            // 总页数
            map.put("pageSize",page.getPageSize());
            // 首页页数
            map.put("isFirstPage",page.isIsFirstPage());
            // 尾页页数
            map.put("isLastPage",page.isIsLastPage());
            // 当前页数的数据
            map.put("stuList",employeeDtoList);
            // 查询所有数据的数量
            map.put("recordNum",page.getTotal());
            return map;
        } catch (Exception e) {
           throw new PageHelperException(HttpStatus.TP_FAILED,"请求失败");
        }
    }

    /**
     * 查询所有楼宇管理员信息
     * @return 查询楼宇管理员信息
     * @throws Exception
     */
    @Override
    public List<EmployeeDto> selectAllFloorManagerInfoList() throws Exception {
        return employeeMapper.selectAllFloorManagerInfoList();
    }

    /**
     * 查询所有楼宇管理员信息服务
     * @return 包装所有楼宇信息map集合
     * @throws Exception
     */
    @Override
    public Map<String, Object> getAllFloorInfoMnangerList() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("floorManagerList",this.selectAllFloorManagerInfoList());
        return map;
    }

    /**
     * 删除单个楼宇管理员信息
     * @param empId 员工id
     * @return 是否删除成功
     * @throws Exception
     */
    @Override
    public Boolean deleteOneFloorManagerInfo(Integer empId) throws Exception {
        return employeeMapper.deleteOneFloorManagerInfo(empId);
    }


    /**
     * 删除单个楼宇管理员信息服务
     * @param empId 员工id
     * @return 是否正确删除
     * @throws Exception
     */
    @Override
    public Boolean deleteOneFloorMannagerService(Integer empId) throws Exception {
        if (empId != null) {
            return this.deleteOneFloorManagerInfo(empId);
        }
        return false;
    }

    /**
     * 批量删除楼宇管理员信息服务
     * @param empIdList 员工id数组集合
     * @return 是否正确删除
     * @throws Exception
     */
    @Override
    public Boolean deleteSomeOfFloorManagerService(List<Integer> empIdList) throws Exception {
        if (empIdList.size() != 0) {
            empIdList.forEach(item -> {
                try {
                    this.deleteOneFloorManagerInfo(item);
                } catch (Exception e) {
                    throw new EmployeeException(HttpStatus.TP_FAILED,"请求失败");
                }
            });
            return true;
        }
        return false;
    }

    /**
     * 插入一条数据
     * @param employee 员工对象
     * @return 是否插入成功
     * @throws Exception
     */
    @Override
    public Boolean insertOneFloorManagerInfo(Employee employee){
        Boolean judge = null;
        try {
            judge =  employeeMapper.insertOneFloorManagerInfo(employee) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return judge;
    }

    /**
     * 添加一条楼宇管理员服务
     * @param emp 员工dto
     * @return 插入是否成功
     */
    @Override
    public Boolean insertOneFloorManagerInfoService(EmployeeDto emp){
        if (emp != null) {
            if (this.selectFloorManagerInfoSame(emp.getEmpNum(),null) > 0) {
                throw new EmployeeException(HttpStatus.TP_FAILED,"员工工号不能重复");
            } else if (this.selectFloorManagerInfoSame(null,emp.getEmpPhone()) > 0) {
                throw new EmployeeException(HttpStatus.TP_FAILED,"员工手机号不能重复");
            } else {
                Integer floorId = floorMapper.selectFloorIdByException(emp.getFloorName());
                if (floorId != null) {
                    return this.insertOneFloorManagerInfo(new Employee(null,emp.getEmpNum()
                            ,emp.getEmpName(),emp.getEmpSex(),emp.getEmpAge()
                            ,emp.getEmpPhone(),emp.getEmpAddress(),emp.getEmpPosition()
                            ,floorId,0));
                }
                return false;
            }
        }
        return false;
    }

    /**
     * 查询手机或者员工职工号
     * @param empNum 员工学号
     * @param empPhone 员工手机号
     * @return 查询结果集数量
     * @throws Exception
     */
    @Override
    public Integer selectFloorManagerInfoSame(String empNum,String empPhone) {
        Integer count = null;
        try {
            count = employeeMapper.selectFloorManagerInfoSame(empNum,empPhone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 更新楼宇信息
     * @param employee 更新楼宇管理员对象
     * @return 是否更新成功
     * @throws Exception
     */
    @Override
    public Boolean updateFloorManagerInfoByException(EmployeeDto employee) throws Exception {
        return employeeMapper.updateFloorManagerInfoByException(employee);
    }

    /**
     * 更新楼宇信息服务
     * @param emp 更新楼宇管理员对象
     * @return 是否更新成功
     */
    @Override
    public Boolean updateFloorManagerInfoByExceptionService(EmployeeDto emp) {
        if (emp != null) {
            if (emp.getEmpNum() != null && !"".equals(emp.getEmpNum())) {
                if (this.selectFloorManagerInfoSame(emp.getEmpNum(),null) > 0) {
                    throw new EmployeeException(HttpStatus.TP_FAILED,"员工工号已经存在");
                }
            }
            if (emp.getEmpPhone() != null && !"".equals(emp.getEmpPhone())) {
                if (this.selectFloorManagerInfoSame(null,emp.getEmpPhone()) > 0) {
                    throw new EmployeeException(HttpStatus.TP_FAILED,"员工手机号已经存在");
                }
            }
            try {
                return this.updateFloorManagerInfoByException(emp);
            } catch (Exception e) {
                throw new EmployeeException(HttpStatus.TP_FAILED,"更新失败");
            }
        }
        return false;
    }

}
