package com.manager.provider.feigin;

import com.manager.domaindto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 远程调用搜索服务
 * @author sunli
 * @date 2020/5/2 0:47
 */
@FeignClient(value = "nacos-user-search")
public interface SearchInterface {

    @GetMapping("/stuSearch/stuNumber/{stuNumber}")
    List<StudentDto> SearchStuInfoByStudentNumber(@PathVariable("stuNumber") String stuNumber);

    @GetMapping("/stuSearch/stuName/{stuName}")
    public List<StudentDto> SearchStuInfoByStudentName(@PathVariable("stuName") String stuName);

    @GetMapping("/floorSearchService/searchFloor/{floorName}")
    public List<floorDto> SearchFloorInfoByFloorName(@PathVariable("floorName") String floorName);

    @GetMapping("/empSearchService/searchNum/{empNum}")
    public List<EmployeeDto> searchEmpListByEmpNum(@PathVariable("empNum")String empNum);

    @GetMapping("/empSearchService/searchName/{empName}")
    public List<EmployeeDto> searchEmpListByEmpName(@PathVariable("empName")String empName);

    @GetMapping("/RecordSearch/searchStuNum/{stuNumber}")
    public List<RecordDto> searchStuNumberController(@PathVariable("stuNumber")String stuNumber);

    @GetMapping("/RecordSearch/searchStuName/{stuName}")
    public List<RecordDto> searchStuNameController(@PathVariable("stuName")String stuName);


    @GetMapping("/hostelSearchService/searchHosNum/{hosNum}")
    public List<HostelDto> searchHostelInfoByHostelNum(@PathVariable("hosNum") String hosNum);

    @GetMapping("/hostelSearchService/searchFloorName/{floorName}")
    public List<HostelDto> searchHostelInfoByFloorName(@PathVariable("floorName")String floorName);

    @GetMapping("/dorSearchService/searchName/{stuName}")
    public List<DormitoryexchangerecordDto> searchByStuNameController(@PathVariable("stuName")String stuName);

    @GetMapping("/dorSearchService/searchNum/{stuNum}")
    public List<DormitoryexchangerecordDto> searchByStuNumController(@PathVariable("stuNum")String stuNum);

    @GetMapping("/hostelSearchService/searchHosByFloor/{floorName}")
    public List<HostelDto> searchHostelInfo(@PathVariable("floorName")String floorName);

    @GetMapping("/hostelSearchService/searchRemaingHosByFloor/{floorName}")
    public List<HostelDto> searchRemaingHosController(@PathVariable("floorName") String floorName);

    @GetMapping("/tbUserSearchService/search/{username}")
    public List<UserDto> searchTbUserController(@PathVariable("username") String username);
}
