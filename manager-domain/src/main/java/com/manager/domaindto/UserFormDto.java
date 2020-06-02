package com.manager.domaindto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * userDTO
 * 接受用户表单的DTO
 * @author sunli
 * @date 2020/4/4 13:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserFormDto implements Serializable {

    private static final long serialVersionUID = -1391040175083772724L;

    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "密码字段不能为空")
    private String password;
}
