package com.manager.download.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author sunli
 * @date 2020/5/14 16:30
 */
public interface UploadService {

    /**
     * 七牛云文件上传服务
     * @param imageFile 文件输入流
     * @return 七牛云oss图片文件地址
     */
    public String uploadService(MultipartFile imageFile);
}
