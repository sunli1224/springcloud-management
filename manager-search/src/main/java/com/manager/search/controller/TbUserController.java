package com.manager.search.controller;

import com.manager.domaindto.UserDto;
import com.manager.search.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sunli
 * @date 2020/5/12 21:26
 */
@RestController
@RequestMapping("/tbUserSearchService")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    @GetMapping("/search/{username}")
    public List<UserDto> searchTbUserController(@PathVariable("username") String username) {
        return tbUserService.selectUserInfoByUserName(username);
    }
}
