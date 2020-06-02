package com.manager.auth.controller;

import com.manager.auth.service.AuthTokenService;
import com.manager.auth.service.UserDatailService;
import com.manager.commons.HttpStatus;
import com.manager.commons.JsonResponse;
import com.manager.commons.JsonResult;
import com.manager.domaindto.UserFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunli
 * @date 2020/3/30 17:13
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UserController {


    @PostMapping(value = "/user")
    public JsonResult judgeUserController(@RequestBody @Valid UserFormDto user, BindingResult bindingResult) throws Exception {
        Map<String, Object> tokenMap = null;
        JsonResult jsonResponse = new JsonResult();
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e -> {
                jsonResponse.setMessage(e.getDefaultMessage());
            });
            jsonResponse.setCode(HttpStatus.TP_FAILED);
        } else {
            tokenMap = userDatailService.judgeUserReal(user.getUsername(), user.getPassword());
            if (tokenMap != null) {
                jsonResponse.setCode(HttpStatus.TP_OK);
                jsonResponse.setMessage("请求成功");
                jsonResponse.setData(tokenMap);
                return jsonResponse;
            }
            jsonResponse.setCode(HttpStatus.TP_FAILED);
            jsonResponse.setMessage("请求失败");
        }
        return jsonResponse;
    }

    @Autowired
    private UserDatailService userDatailService;

}
