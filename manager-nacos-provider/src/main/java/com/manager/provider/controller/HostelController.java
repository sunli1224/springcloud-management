package com.manager.provider.controller;

import com.manager.commons.HttpStatus;
import com.manager.commons.JsonResponse;
import com.manager.commons.JsonResult;
import com.manager.domaindto.HostelDto;
import com.manager.provider.feigin.SearchInterface;
import com.manager.provider.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunli
 * @date 2020/4/23 16:51
 */
@RestController
@RequestMapping("/hostelservice")
public class HostelController {

    @Autowired
    private HostelService hostelService;


    @Autowired
    private SearchInterface searchInterface;


    /**
     * 宿舍信息分页服务
     * @param ids 页数
     * @return 宿舍管理分页信息
     */
    @GetMapping("/hostelPaging/{ids}")
    public JsonResponse getHostelInfoPaging(@PathVariable("ids") Integer ids) {
        if (ids != null) {
            Map<String, Object> map = hostelService.getHostelInfoPaging(ids);
            return JsonResponse
                    .builder()
                    .code(HttpStatus.TP_OK)
                    .data(map)
                    .message("请求成功")
                    .build();
        }
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_FAILED)
                .message("分页失败")
                .build();
    }

    /**
     * 查询所有宿舍相关信息服务
     * @return 所有宿舍信息数据包
     * @throws Exception
     */
    @GetMapping("/selecthostel")
    public JsonResponse selectHostelInfoListController() {
        Map<String,Object> map = hostelService.getHostelInfoListService();
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_OK)
                .data(map)
                .message("请求成功")
                .build();
    }


    /**
     * 添加宿舍服务
     * @param hostelDto 新添加的hostel对象
     * @param bindingResult valid 错误
     * @return 是否添加成功数据包
     * @throws Exception
     */
    @PostMapping("/insertOne")
    public JsonResult insertOneHostelInfoController(@RequestBody @Valid HostelDto hostelDto, BindingResult bindingResult) throws Exception {
        JsonResult jsonResult = new JsonResult();
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e -> {
                jsonResult.setMessage(e.getDefaultMessage());
            });
            jsonResult.setCode(HttpStatus.TP_FAILED);
        } else {
            if (hostelService.insertOneHostInfoService(hostelDto)) {
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
     * 删除单个宿舍信息服务
     * @param hosId 宿舍id
     * @return 是否成功删除数据包
     * @throws Exception
     */
    @GetMapping("/deleteOne/{hosId}")
    public JsonResponse deleteOneHostelInfoController(@RequestBody @PathVariable("hosId") Integer hosId) throws Exception {
        if (hostelService.deleteHostelInfoService(hosId)) {
            return JsonResponse
                    .builder()
                    .code(HttpStatus.TP_OK)
                    .message("删除成功")
                    .build();
        }
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_FAILED)
                .message("删除失败")
                .build();
    }

    /**
     * 删除多个宿舍信息服务
     * @param hosIdList 宿舍id集合
     * @return 是否删除成功数据包
     * @throws Exception
     */
    @PostMapping("/deleteSome")
    public JsonResponse deleteSomeHostelInfoContrller(@RequestBody List<Integer> hosIdList) throws Exception {
        if (hostelService.deleteSomeHostelInfoService(hosIdList)) {
            return JsonResponse
                    .builder()
                    .code(HttpStatus.TP_OK)
                    .message("删除成功")
                    .build();
        }
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_FAILED)
                .message("删除失败")
                .build();
    }

    /**
     * 修改宿舍信息服务
     * @param hostelDto 更新宿舍信息
     * @return 是否修改成功
     * @throws Exception
     */
    @PostMapping("/updateOne")
    public JsonResponse updateHostelInfoController(@RequestBody HostelDto hostelDto) {
        if (hostelService.updateHostelInfoService(hostelDto)) {
            return JsonResponse
                    .builder()
                    .code(HttpStatus.TP_OK)
                    .message("修改成功")
                    .build();
        }
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_FAILED)
                .message("修改失败")
                .build();
    }


    /**
     * 搜索服务通过宿舍号
     * @param hosNum 宿舍号
     * @return 搜索集合
     */
    @GetMapping("/searchHostelNum/{hosNum}")
    public JsonResponse searchHostelInfoByHostelNumController(@PathVariable("hosNum")String hosNum) {
        Map<String,Object> map = new HashMap<>();
        map.put("stuList",searchInterface.searchHostelInfoByHostelNum(hosNum));
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_OK)
                .message("搜索成功")
                .data(map)
                .build();
    }

    /**
     * 搜索服务通过楼宇名
     * @param floorName 楼宇名
     * @return 搜索集合
     */
    @GetMapping("/searchFloorName/{floorName}")
    public JsonResponse searchHostelInfoByFloorNameController(@PathVariable("floorName")String floorName) {
        Map<String,Object> map = new HashMap<>();
        map.put("stuList",searchInterface.searchHostelInfoByFloorName(floorName));
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_OK)
                .message("搜索成功")
                .data(map)
                .build();
    }


    /**
     * 搜素有剩余的宿舍通过楼宇名
     * @param floorName 楼宇名
     * @return 宿舍集合数据包
     */
    @GetMapping("/searchRemaingHos/{floorName}")
    public JsonResponse searchRemaingHosController(@PathVariable("floorName") String floorName) {
        Map<String,Object> map = new HashMap<>();
        map.put("stuList",searchInterface.searchRemaingHosController(floorName));
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_OK)
                .message("搜索成功")
                .data(map)
                .build();
    }

}
