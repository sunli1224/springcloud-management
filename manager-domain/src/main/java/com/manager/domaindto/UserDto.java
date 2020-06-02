package com.manager.domaindto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.manager.domain.TbRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 用户DTO
 * @author sunli
 * @date 2020/5/9 17:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable {

    private static final long serialVersionUID = -5132679538806124796L;

    @Column(name = "id")
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "username")
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码，加密存储
     */
    @Column(name = "`password`")
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 注册手机号
     */
    @Column(name = "phone")
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3-578]\\d{9}$" ,message = "手机号不符合")
    private String phone;

    /**
     * 注册邮箱
     */
    @Column(name = "email")
    @NotBlank(message = "邮箱不能为空")
    @Pattern(regexp = "^(\\w-*\\.*)+@(\\w-?)+(\\.\\w{2,})+$" ,message = "邮箱不符合")
    private String email;

    @Column(name = "imge")
    private String imge;

    @Column(name = "created")
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date created;

    @Column(name = "updated")
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime updated;

    /**
     * 角色名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 角色英文名称
     */
    @Column(name = "enname")
    private String enname;


}
