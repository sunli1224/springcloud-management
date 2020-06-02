package com.manager.provider.controller;

import com.google.common.base.Strings;
import com.manager.commons.*;
import com.manager.domaindto.StudentDto;
import com.manager.exception.AuthException;
import com.manager.provider.feigin.SearchInterface;
import com.manager.provider.feigin.RedisInterface;
import com.manager.provider.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 学生管理服务
 * @author sunli
 * @date 2020/4/9 3:11
 */
@RestController
@RequestMapping("/stuService")
public class StuController {


    @Value("${upload.file.path}")
    private String file_path;

    @PostMapping("/addAll")
    public JsonResponse AddAllInfoController(@RequestBody String excelPath) {
        String path = file_path + excelPath.substring(0,excelPath.length()-1) + ".xlsx";
        if (studentService.addAllService(path)) {
            return JsonResponse
                    .builder()
                    .code(HttpStatus.TP_OK)
                    .message("插入成功")
                    .build();
        }
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_FAILED)
                .message("插入失败")
                .build();
    }

    /**
     * 上传excel到本地
     * @param excelFile excel文件
     * @return 是否上传成功
     */
    @PostMapping("/uploadOne")
    public JsonResponse uplodExcelController(MultipartFile excelFile) {
        String saveFilename = null;
        try {
            String fileName = excelFile.getOriginalFilename();
            //判断是否有文件且是否为图片
            if (!Strings.isNullOrEmpty(fileName) && fileUtils.isExcelFile(fileName)) {
                //创建输出文件对象
                String uid = UUID.randomUUID().toString();
                saveFilename = uid + fileUtils.getFileType(fileName);
                File outFile = new File(file_path + saveFilename);
                excelFile.transferTo(outFile);
                    return JsonResponse
                            .builder()
                            .code(HttpStatus.TP_OK)
                            .data(uid)
                            .message("上传成功")
                            .build();
            }
            return JsonResponse
                    .builder()
                    .code(HttpStatus.TP_FAILED)
                    .message("上传失败")
                    .build();
        } catch (Exception e) {
            throw new AuthException(HttpStatus.TP_FAILED, "上传失败");
        }
    }

    /**
     * 学生数据分页服务
     * @param ids 当前请求页数
     * @return 分页数据集合
     * @throws Exception 请求失败错误
     */
    @GetMapping("/stuManager/{ids}")
    public JsonResponse getStudentPage(@PathVariable("ids") Integer ids) throws Exception {
        Map<String,Object> map;
        map = studentService.getPagingLock(ids);
        return JsonResponse
                .builder()
                .code(200)
                .message("请求成功")
                .data(map)
                .build();
    }

    /**
     * 学生模块
     * 搜索服务
     * 根据学生姓名
     * @param stuNumber 学号
     * @return 学生数据集合
     * @throws Exception
     */
    @GetMapping("/searchStuNumber/{stuNumber}")
    public JsonResponse searchStuNumber(@PathVariable("stuNumber") String stuNumber) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<StudentDto> studentDtoList = searchInterface.SearchStuInfoByStudentNumber(stuNumber);
        map.put("stuList",studentDtoList);
        return JsonResponse
                .builder()
                .code(200)
                .message("请求成功")
                .data(map)
                .build();
    }

    /**
     * 学生模块
     * 搜索服务
     * 根据学生姓名
     * 远程调用搜索服务
     * @param stuName 学生姓名
     * @return 学生数据集合
     * @throws Exception
     */
    @GetMapping("/searchStuName/{stuName}")
    public JsonResponse searchStuName(@PathVariable("stuName") String stuName) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<StudentDto> studentDtoList = searchInterface.SearchStuInfoByStudentName(stuName);
        map.put("stuList",studentDtoList);
        return JsonResponse
                .builder()
                .code(200)
                .message("请求成功")
                .data(map)
                .build();
    }

    /**
     * 单个删除服务
     * @param stuNumber 学生学号
     * @return 返回数据包
     * @throws Exception
     */
    @GetMapping("/delete/{stuNumber}")
    public JsonResponse delOneStudent(@PathVariable("stuNumber") String stuNumber) throws Exception {
        if (studentService.deleteStudentService(stuNumber)) {
            return JsonResponse
                    .builder()
                    .code(200)
                    .message("请求成功")
                    .build();
        }
        return JsonResponse
                .builder()
                .code(500)
                .message("请求失败")
                .build();
    }

    /**
     * 批量删除服务
     * @param stuNumberList 学生学号集合
     * @return
     * @throws Exception
     */
    @PostMapping("/delAll")
    public JsonResponse deleteAllStudentList(@RequestBody List<String> stuNumberList) throws Exception {
        if (studentService.deleteAllStudentListService(stuNumberList)) {
            return JsonResponse
                    .builder()
                    .code(200)
                    .message("请求成功")
                    .build();
        }
        return JsonResponse
                .builder()
                .code(500)
                .message("请求失败")
                .build();
    }

    /**
     * 更新学生信息服务
     * @param m 接受参数对应学生domain映射
     * @return 是否成功的数据包
     * @throws Exception
     */
    @PostMapping("/update")
    public JsonResponse updateOneController(@RequestBody StudentDto m) throws Exception {
        Boolean judge;
        if (m != null && m.getStuId() != null) {
            if (studentService.updateStudentInfoByIdService(m)) {
                return JsonResponse
                        .builder()
                        .code(200)
                        .message("请求成功")
                        .build();
            }
        }
        return JsonResponse
                .builder()
                .code(500)
                .message("请求失败")
                .build();
    }

    @Autowired
    private StudentService studentService;

    @Autowired
    private SearchInterface searchInterface;

    @Autowired
    private RedisInterface redisInterface;
}
