package com.manager.domaindto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @author sunli
 * @date 2020/5/14 4:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassChangeDto implements Serializable {

    private static final long serialVersionUID = 3285194556504172955L;
    private Long ids;
    private String oldPass;
    private String newPass;
    private String reNewPass;
}
