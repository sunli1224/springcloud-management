package com.manager.provider.controller;

import com.manager.commons.HttpStatus;
import com.manager.commons.JsonResponse;
import com.manager.commons.JsonResult;
import com.manager.domain.Employee;
import com.manager.domaindto.EmployeeDto;
import com.manager.exception.EmployeeException;
import com.manager.provider.feigin.SearchInterface;
import com.manager.provider.service.FloorManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 楼宇管理员管理模块
 * @author sunli
 * @date 2020/4/22 14:57
 */
@RestController
@RequestMapping("/floormanager")
public class FloorManagerController {

    @Autowired
    private FloorManagerService floorManagerService;

    @Autowired
    private SearchInterface searchInterface;

    /**
     * 楼宇管理员管理分页服务
     * @return 分页数据包
     */
    @GetMapping("/floorManangerPaging/{ids}")
    public JsonResponse getFloorManagerListPaging(@PathVariable("ids") Integer ids) {
        Map<String,Object> map = floorManagerService.selectAllFloorManagerInfoPaging(ids);
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_OK)
                .message("请求成功")
                .data(map)
                .build();
    }

    /**
     * 查询所有楼宇管理员信息服务
     * @return 所有楼宇管理员信息数据包
     */
    @GetMapping("/getallempinfo")
    public JsonResponse getAllEmpListInfoController() {
        Map<String,Object> map;
        try {
            map = floorManagerService.getAllFloorInfoMnangerList();
        } catch (Exception e) {
            throw new EmployeeException(HttpStatus.TP_FAILED,"请求失败");
        }
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_OK)
                .message("请求成功")
                .data(map)
                .build();
    }

    /**
     * 删除单个楼宇管理员信息服务
     * @param empId 员工id
     * @return 是否成功数据包
     */
    @GetMapping("/deloneinfo/{empId}")
    public JsonResponse deleteOneEmplyeeController(@PathVariable("empId") Integer empId) {
        Boolean judge;
        try {
            judge = floorManagerService.deleteOneFloorMannagerService(empId);
        } catch (Exception e) {
            throw new EmployeeException(HttpStatus.TP_FAILED,"请求失败");
        }
        if (judge) {
            return JsonResponse
                    .builder()
                    .code(HttpStatus.TP_OK)
                    .message("请求成功")
                    .build();
        }
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_FAILED)
                .message("请求失败")
                .build();
    }

    /**
     * 删除多个楼宇管理员信息服务
     * @param empIdList 楼宇管理员id集合
     * @return 是否删除成功数据包
     */
    @PostMapping("/deletesome")
    public JsonResponse deleteSomeOfFloorManagerController(@RequestBody ArrayList<Integer> empIdList) {
        try {
            if (floorManagerService.deleteSomeOfFloorManagerService(empIdList)) {
                return JsonResponse
                        .builder()
                        .code(HttpStatus.TP_OK)
                        .message("请求成功")
                        .build();
            }
            return JsonResponse
                    .builder()
                    .code(HttpStatus.TP_FAILED)
                    .message("请求失败")
                    .build();
        } catch (Exception e) {
            throw new EmployeeException(HttpStatus.TP_FAILED,"请求失败");
        }
    }

    /**
     * 添加一条楼宇信息服务
     * @param employeeDto 楼宇对象
     * @return 是否添加成功
     */
    @PostMapping("/addinfo")
    public JsonResult addFloorManagerInfo(@RequestBody @Valid EmployeeDto employeeDto, BindingResult bindingResult)throws Exception {
        JsonResult jsonResponse = new JsonResult();
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e -> {
                jsonResponse.setMessage(e.getDefaultMessage());
            });
            jsonResponse.setCode(HttpStatus.TP_FAILED);
        } else {
            if (floorManagerService.insertOneFloorManagerInfoService(employeeDto)) {
                jsonResponse.setCode(HttpStatus.TP_OK);
                jsonResponse.setMessage("添加成功");
                return jsonResponse;
            }
            jsonResponse.setCode(HttpStatus.TP_FAILED);
            jsonResponse.setMessage("添加失败");
        }
        return jsonResponse;
    }

    /**
     * 更新用户的信息
     * @param employee 更新用户的信息
     * @return 是否成功数据包
     * @throws Exception
     */
    @PostMapping("/updateinfo")
    public JsonResult updateFloorManagerInfoController(@RequestBody EmployeeDto employee) throws Exception {
            JsonResult jsonResponse = new JsonResult();
            if (floorManagerService.updateFloorManagerInfoByExceptionService(employee)) {
                jsonResponse.setCode(HttpStatus.TP_OK);
                jsonResponse.setMessage("更新成功");
                return jsonResponse;
            }
            jsonResponse.setCode(HttpStatus.TP_FAILED);
            jsonResponse.setMessage("更新失败");
            return jsonResponse;
    }


    /**
     * 搜索服务
     * 根据员工姓名进行搜索
     * @param empName 员工姓名
     * @return 员工数据集合数据包
     */
    @GetMapping("/searchName/{empName}")
    public JsonResponse searchEmpInfoByEmpName (@PathVariable("empName")String empName) {
        if (empName != null) {
            Map<String,Object> map = new HashMap<>();
            List<EmployeeDto> employeeDtoList = searchInterface.searchEmpListByEmpName(empName);
            map.put("stuList", employeeDtoList);
            return JsonResponse
                    .builder()
                    .code(HttpStatus.TP_OK)
                    .message("查询成功")
                    .data(map)
                    .build();
        }
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_FAILED)
                .message("查询失败")
                .build();
    }

    /**
     * 搜索服务
     * 根据员工工号进行搜索
     * @param empNum 工号
     * @return 员工信息数据包
     */
    @GetMapping("/searchNum/{empNum}")
    public JsonResponse searchEmpInfoByEmpNum (@PathVariable("empNum")String empNum) {
        if (empNum != null) {
            Map<String,Object> map = new HashMap<>();
            List<EmployeeDto> employeeDtoList = searchInterface.searchEmpListByEmpNum(empNum);
            map.put("stuList",employeeDtoList);
            return JsonResponse
                    .builder()
                    .code(HttpStatus.TP_OK)
                    .message("查询成功")
                    .data(map)
                    .build();
        }
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_FAILED)
                .message("查询失败")
                .build();
    }

}
