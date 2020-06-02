package com.manager.provider.controller;

import com.manager.commons.HttpStatus;
import com.manager.commons.JsonResponse;
import com.manager.domain.Floor;
import com.manager.domaindto.floorDto;
import com.manager.exception.floorException;
import com.manager.provider.feigin.SearchInterface;
import com.manager.provider.service.floorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 楼宇管理模块
 * @author sunli
 * @date 2020/4/21 14:00
 */
@RestController
@RequestMapping("/floorService")
public class FloorController {

    @Autowired
    private floorService floorService;

    @Autowired
    private SearchInterface searchInterface;


    /**
     * 分页服务
     * 通过分页页数查询对应的楼宇信息
     * @param ids 页数
     * @return 楼宇信息分页数据包
     */
    @GetMapping("/floorPaging/{ids}")
    public JsonResponse floorListInfoPagingHelperService(@PathVariable("ids") Integer ids) {
        Map<String, Object> map = floorService.floorInfoPaging(ids);
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_OK)
                .data(map)
                .message("请求成功")
                .build();
    }

    /**
     * 查询所有楼宇信息数据包
     * @return 所有楼宇信息数据集合
     * @throws Exception
     */
    @GetMapping("/allfloorinfo")
    public JsonResponse getAllFloorInfoController(){
        Map<String,Object> map;
        try {
             map = floorService.selectAllFloorListService();
        } catch (Exception e) {
            throw new floorException(HttpStatus.TP_FAILED,"请求失败");
        }
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_OK)
                .message("请求成功")
                .data(map)
                .build();
    }

    /**
     * 批量删除楼宇服务
     * @param idList 楼宇id集合
     * @return 是否成功数据包
     */
    @PostMapping("/delallfloorinfo")
    public JsonResponse delAllFloorInfoController(@RequestBody ArrayList<Integer> idList) {
        try {
            if (floorService.delAllFloorInfoListService(idList)) {
                return JsonResponse
                        .builder()
                        .code(HttpStatus.TP_OK)
                        .message("请求成功")
                        .build();
            }
        } catch (Exception e) {
            throw new floorException(HttpStatus.TP_FAILED,"请求失败");
        }
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_FAILED)
                .message("请求失败")
                .build();
    }


    /**
     * 删除单个楼宇信息服务
     * @param id 楼宇id
     * @return 返回是否成功删除的数据包
     */
    @GetMapping("/delfloorinfo/{id}")
    public JsonResponse delOneFloorInfoController(@PathVariable("id") Integer id) {
        try {
            if (floorService.delOneFloorInfoService(id)) {
                return JsonResponse
                        .builder()
                        .code(HttpStatus.TP_OK)
                        .message("请求成功")
                        .build();
            }
        } catch (Exception e) {
            throw new floorException(HttpStatus.TP_FAILED,"请求失败");
        }
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_FAILED)
                .message("请求失败")
                .build();
    }

    /**
     * 搜索服务
     * 根据楼宇的名字
     * @param floorName 楼宇名
     * @return 楼宇信息数据包
     */
    @GetMapping("/searchfloor/{floorName}")
    public JsonResponse searchFloorInfoByFloorNameController(@PathVariable("floorName") String floorName) {
        Map<String,Object> map = new HashMap<>();
        if (floorName != null) {
            try {
                List<floorDto> floorDtoList = searchInterface.SearchFloorInfoByFloorName(floorName);
                map.put("floorList", floorDtoList);
                return JsonResponse
                        .builder()
                        .code(HttpStatus.TP_OK)
                        .message("请求成功")
                        .data(map)
                        .build();
            } catch (Exception e) {
                throw new floorException(HttpStatus.TP_FAILED,"请求失败");
            }
        }
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_FAILED)
                .message("请求失败")
                .build();
    }

    /**
     * 插入一条楼宇信息服务
     * @param floor 楼宇对象
     * @return 是否插入成功数据包
     */
    @PostMapping("/insertfloor")
    public JsonResponse insertOneFloorInfoController(@RequestBody Floor floor) {
        Boolean judge;
        try {
            if (floorService.insertFloorInfoService(floor)) {
                return JsonResponse
                        .builder()
                        .code(HttpStatus.TP_OK)
                        .message("插入成功")
                        .build();
            } else {
                return JsonResponse
                        .builder()
                        .code(HttpStatus.TP_FAILED)
                        .message("请求失败")
                        .build();
            }
        } catch (Exception e) {
            throw new floorException(HttpStatus.TP_FAILED,"请求失败");
        }
    }

    /**
     * 查找没有楼宇名的集合
     * @return 没有楼宇管理员的楼宇名集合
     */
    @GetMapping("/selectnoemp")
    public JsonResponse selectNoFloorMangerFloorNameController() {
        Map<String,Object> map;
        try {
            map = floorService.selectFloorIdNoFloorManagerService();
            return JsonResponse
                    .builder()
                    .code(HttpStatus.TP_OK)
                    .message("插入成功")
                    .data(map)
                    .build();
        } catch (Exception e) {
            throw new floorException(HttpStatus.TP_FAILED,"请求失败");
        }
    }


    @PostMapping("/updateOne")
    public JsonResponse updateOneController(@RequestBody floorDto floorDto){
        if (floorService.updateFloorInfoService(floorDto)) {
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
