package com.manager.provider.controller;

import com.manager.commons.HttpStatus;
import com.manager.commons.JsonResponse;
import com.manager.commons.JsonResult;
import com.manager.domaindto.RecordDto;
import com.manager.exception.RecordException;
import com.manager.provider.feigin.SearchInterface;
import com.manager.provider.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 缺勤管理
 * @author sunli
 * @date 2020/5/6 15:55
 */
@RestController
@RequestMapping("/recordService")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @Autowired
    private SearchInterface searchInterface;

    /**
     * 分页服务
     * @param ids 页数
     * @return 缺勤记录数据包
     */
    @GetMapping("/recordPaging/{ids}")
    public JsonResponse getAllRecordInfoController(@PathVariable("ids")Integer ids){
        Map<String, Object> map = recordService.getAllRecordInfoPagingService(ids);
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_OK)
                .message("请求成功")
                .data(map)
                .build();
    }

    /**
     * 删除单个记录服务
     * @param id 缺勤id
     * @return 是否删除成功数据包
     */
    @GetMapping("/delOne/{id}")
    public JsonResponse delOneRecordInfoController(@PathVariable("id") Integer id) {
        if (recordService.delOneRecordService(id)) {
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
     * 批量删除缺勤记录信息
     * @param idList 缺勤记录id集合
     * @return 是否删除成功数据包
     */
    @PostMapping("/delSome")
    public JsonResponse delSomeRecordInfoController(@RequestBody List<Integer> idList) {
        if(recordService.delSomeRecordService(idList)) {
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
     * 添加一条缺勤记录
     * @param recordDto record对象
     * @return 是否添加成功
     */
    @PostMapping("/insertOne")
    public JsonResult insertOneRecordInfoController(@RequestBody @Valid RecordDto recordDto, BindingResult bindingResult) throws Exception{
        JsonResult jsonResponse = new JsonResult();
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e -> {
                jsonResponse.setMessage(e.getDefaultMessage());
            });
            jsonResponse.setCode(HttpStatus.TP_FAILED);
        } else {
            if (recordService.insertOneService(recordDto)) {
                jsonResponse.setCode(HttpStatus.TP_OK);
                jsonResponse.setMessage("添加成功");
            } else {
                jsonResponse.setCode(HttpStatus.TP_FAILED);
                jsonResponse.setMessage("添加失败");
            }
        }
        return jsonResponse;
    }

    /**
     * 更新一条缺勤记录
     * @param recordDto record对象
     * @return 是否更新成功
     */
    @PostMapping("/updateOne")
    public JsonResponse updateOneRecordInfoController(@RequestBody RecordDto recordDto){
        if (recordService.updateOneRecordInfoService(recordDto)) {
            return JsonResponse
                    .builder()
                    .code(HttpStatus.TP_OK)
                    .message("更新成功")
                    .build();
        } else {
            return JsonResponse
                    .builder()
                    .code(HttpStatus.TP_OK)
                    .message("更新失败")
                    .build();
        }
    }


    @GetMapping("/searchNum/{stuNumber}")
    public JsonResponse searchStuNum(@PathVariable("stuNumber")String stuNumber){
        Map<String,Object> map = new HashMap<>();
        map.put("stuList",searchInterface.searchStuNumberController(stuNumber));
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_OK)
                .message("搜索成功")
                .data(map)
                .build();
    }

    @GetMapping("/searchName/{stuName}")
    public JsonResponse searchStuName(@PathVariable("stuName")String stuName){
        Map<String,Object> map = new HashMap<>();
        map.put("stuList",searchInterface.searchStuNameController(stuName));
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_OK)
                .message("搜索成功")
                .data(map)
                .build();
    }

    @GetMapping("/searchHos/{floorName}")
    public JsonResponse searchHosByFloorName(@PathVariable("floorName") String floorName) {
        Map<String,Object> map = new HashMap<>();
        map.put("stuList",searchInterface.searchHostelInfo(floorName));
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_OK)
                .message("搜索成功")
                .data(map)
                .build();
    }





}
