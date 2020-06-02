package com.manager.provider.controller;

import com.google.common.base.Strings;
import com.manager.commons.*;
import com.manager.domaindto.PassChangeDto;
import com.manager.domaindto.UserDto;
import com.manager.exception.AuthException;
import com.manager.provider.feigin.SearchInterface;
import com.manager.provider.feigin.UpAndDownLoadInterface;
import com.manager.provider.service.AuthManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author sunli
 * @date 2020/5/12 3:18
 */
@RestController
@RequestMapping("/authManagerService")
public class AuthManagerController {


    @Autowired
    private AuthManagerService authManagerService;

    @Autowired
    private SearchInterface searchInterface;


    @Autowired
    private UpAndDownLoadInterface upAndDownLoadInterface;

    @GetMapping("/paging/{ids}")
    public JsonResponse pagingController(@PathVariable("ids") Integer ids) {
        Map<String,Object> map = authManagerService.pagingAllUserInfo(ids);
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_OK)
                .message("分页成功")
                .data(map)
                .build();
    }

    @GetMapping("/delOne/{id}")
    public JsonResponse delOneController(@PathVariable("id") Integer id) {
        if(authManagerService.deleteOneService(id)){
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

    @PostMapping("/delSome")
    public JsonResponse delSomeController(@RequestBody List<Integer> idList) {
        if (authManagerService.deleteSomeService(idList)) {
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

    @PostMapping("/insertOne")
    public JsonResult insertOneController(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
        JsonResult jsonResponse = new JsonResult();
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e -> {
                jsonResponse.setMessage(e.getDefaultMessage());
            });
            jsonResponse.setCode(HttpStatus.TP_FAILED);
        } else {
            if (authManagerService.insertUserInfoService(userDto)) {
                jsonResponse.setCode(HttpStatus.TP_OK);
                jsonResponse.setMessage("添加成功");
                return jsonResponse;
            }
            jsonResponse.setCode(HttpStatus.TP_FAILED);
            jsonResponse.setMessage("添加失败");
        }
        return jsonResponse;
    }

    @PostMapping("/updateTwo")
    public JsonResponse updateUserInfoController(@RequestBody UserDto userDto) {
        if (authManagerService.updateUserPhoneOrEmailService(userDto)) {
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

    @PostMapping("/updateOne")
    public JsonResult updateOneController(@RequestBody UserDto userDto){
        JsonResult jsonResponse = new JsonResult();
        if (authManagerService.updateUserInfoService(userDto)) {
            jsonResponse.setCode(HttpStatus.TP_OK);
            jsonResponse.setMessage("更新成功");
            return jsonResponse;
        }
        jsonResponse.setCode(HttpStatus.TP_FAILED);
        jsonResponse.setMessage("更新失败");

        return jsonResponse;
    }


    @PostMapping("/changeUserSecret")
    public JsonResponse changeUserSecretController(@RequestBody PassChangeDto passChangeDto) {
        if (authManagerService.changeUserSecretService(passChangeDto.getIds(), passChangeDto.getOldPass(), passChangeDto.getNewPass(), passChangeDto.getReNewPass())){
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


    @GetMapping("/searchUser/{username}")
    public JsonResponse searchController(@PathVariable("username") String username) {
        Map<String,Object> map = new HashMap<>();
        map.put("stuList",searchInterface.searchTbUserController(username));
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_OK)
                .message("搜索成功")
                .data(map)
                .build();
    }


    @PostMapping("/uploadImg")
    public JsonResponse upLoadImgController(@RequestParam("imageFile") MultipartFile imageFile,@RequestParam("id") long id) {
        Map<String, Object> map = new HashMap<>();
        String url = upAndDownLoadInterface.upLoadImgController(imageFile);
        if (url != null) {
            if (authManagerService.updateUserHeaderImgService(id,url)) {
                map.put("imgUrl", url);
                return JsonResponse
                        .builder()
                        .code(HttpStatus.TP_OK)
                        .message("上传成功")
                        .data(map)
                        .build();
            }
        }
        return JsonResponse
                .builder()
                .code(HttpStatus.TP_FAILED)
                .message("上传失败")
                .build();
    }

}
