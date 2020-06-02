package com.manager.provider.feigin;

import com.manager.provider.config.FeignSpringFormEncoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author sunli
 * @date 2020/5/14 16:57
 */
@FeignClient(value = "nacos-load-consumer", configuration = FeignSpringFormEncoder.class)
public interface UpAndDownLoadInterface {

    @PostMapping(value = "/qinNiuUpload/uploadImg", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upLoadImgController(@RequestPart("imageFile") MultipartFile imageFile);
}
