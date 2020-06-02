package com.manager.provider.controller;

import com.manager.commons.HttpStatus;
import com.manager.commons.JsonResponse;
import com.manager.commons.JsonResult;
import com.manager.domaindto.DormitoryexchangerecordDto;
import com.manager.provider.feigin.SearchInterface;
import com.manager.provider.service.DormitoryexchangerecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunli
 * @date 2020/4/24 0:24
 */
@RestController
@RequestMapping("/hostelChangeRecord")
public class DormitoryExchangeRecordController {

    @Autowired
    private DormitoryexchangerecordService dorService;

    @Autowired
    private SearchInterface searchInterface;

    /**
     * 分页服务
     * @param ids 页数
     * @return 分页信息
     */
    @GetMapping("/pagingInfo/{ids}")
    public JsonResponse pagingInfoController(@PathVariable("ids") Integer ids){
        Map<String,Object> map = dorService.derInfoPagingService(ids);
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_OK)
                .message("分页成功")
                .data(map)
                .build();
    }

    /**
     * 单个删除
     * @param id id
     * @return 是否删除成功
     */
    @GetMapping("/delOne/{id}")
    public JsonResponse delOneController(@PathVariable("id") Integer id) {
        if (dorService.delOneService(id)){
            return JsonResponse
                    .builder()
                    .code(HttpStatus.TP_OK)
                    .message("删除成功")
                    .build();
        } else {
            return JsonResponse
                    .builder()
                    .code(HttpStatus.TP_FAILED)
                    .message("删除失败")
                    .build();
        }
    }


    /**
     * 批量删除
     * @param idList id集合
     * @return 是否删除成功
     */
    @PostMapping("/delSome")
    public JsonResponse delSomeController(@RequestBody List<Integer> idList) {
        if(dorService.delSomeService(idList)){
            return JsonResponse
                    .builder()
                    .code(HttpStatus.TP_OK)
                    .message("删除成功")
                    .build();
        } else {
            return JsonResponse
                    .builder()
                    .code(HttpStatus.TP_FAILED)
                    .message("删除失败")
                    .build();
        }
    }

    /**
     * 添加一条记录
     * @param dro 添加对象
     * @param bindingResult
     * @return 是否添加成功
     */
    @PostMapping("/insertOne")
    public JsonResult insertOneController(@RequestBody @Valid DormitoryexchangerecordDto dro, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult();
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e -> {
                jsonResult.setMessage(e.getDefaultMessage());
            });
            jsonResult.setCode(HttpStatus.TP_FAILED);
        } else {
            if (dorService.insertOneService(dro)) {
                jsonResult.setCode(HttpStatus.TP_OK);
                jsonResult.setMessage("添加成功");
                return jsonResult;
            }else {
                jsonResult.setCode(HttpStatus.TP_FAILED);
                jsonResult.setMessage("请求失败");
            }
        }
        return jsonResult;
    }

    /**
     * 搜索服务
     * @param stuName 学生姓名
     * @return 搜索结果
     */
    @GetMapping("/searchName/{stuName}")
    public JsonResponse searchByStuNameController(@PathVariable("stuName")String stuName) {
        Map<String,Object> map = new HashMap<>();
        map.put("stuList",searchInterface.searchByStuNameController(stuName));
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_OK)
                .message("搜索成功")
                .data(map)
                .build();
    }

    /**
     * 搜索服务
     * @param stuNum 学号
     * @return 搜索结果
     */
    @GetMapping("/searchNum/{stuNum}")
    public JsonResponse searchByStuNumController(@PathVariable("stuNum")String stuNum) {
        Map<String,Object> map = new HashMap<>();
        map.put("stuList",searchInterface.searchByStuNumController(stuNum));
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_OK)
                .message("搜索成功")
                .data(map)
                .build();
    }


    /**
     * 更新寝室调换信息
     * @param dormitoryexchangerecordDto 更新对象
     * @return 更新结果数据包
     */
    @PostMapping("/updateOne")
    public JsonResponse updateOneDerInfoController(@RequestBody DormitoryexchangerecordDto dormitoryexchangerecordDto) {
        if (dorService.updateDerInfoService(dormitoryexchangerecordDto)) {
            return JsonResponse
                    .builder()
                    .code(HttpStatus.TP_OK)
                    .message("更新成功")
                    .build();
        }
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_FAILED)
                .message("更新失败")
                .build();
    }

}
