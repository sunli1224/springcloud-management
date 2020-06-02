package com.manager.download.service;

import com.google.common.base.Strings;
import com.manager.commons.HttpStatus;
import com.manager.commons.ImageUtils;
import com.manager.commons.JsonResponse;
import com.manager.commons.QiNiuUtils;
import com.manager.exception.AuthException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author sunli
 * @date 2020/5/14 16:31
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Value("${upload.file.path}")
    private String file_path;

    @Override
    public String uploadService(MultipartFile imageFile) {
        QiNiuUtils qiNiuUtils = new QiNiuUtils();
        String saveFilename = null;
        try {
            String fileName = imageFile.getOriginalFilename();
            //判断是否有文件且是否为图片
            if (!Strings.isNullOrEmpty(fileName) && ImageUtils.isImageFile(fileName)) {
                //创建输出文件对象
                saveFilename = UUID.randomUUID().toString() + ImageUtils.getFileType(fileName);
                File outFile = new File(file_path + saveFilename);
                imageFile.transferTo(outFile);
                String imgUrl = qiNiuUtils.upload(file_path + saveFilename,saveFilename);
                if (imgUrl != null) {
                    if (outFile.exists()) {
                        outFile.delete();
                    }
                    return imgUrl;
                }
            }
            return null;
        } catch (Exception e) {
            throw new AuthException(HttpStatus.TP_FAILED, "上传失败");
        }
    }
}
