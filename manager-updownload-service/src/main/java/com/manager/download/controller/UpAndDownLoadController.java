package com.manager.download.controller;

import com.manager.download.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author sunli
 * @date 2020/5/14 16:31
 */
@RestController
@RequestMapping("/qinNiuUpload")
public class UpAndDownLoadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/uploadImg")
    public String upLoadImgController(MultipartFile imageFile){
        return uploadService.uploadService(imageFile);
    }
}
