package com.manager.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
*@author sunli
* @date 2020/5/9 16:39
*/  
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user")
public class TbUser implements Serializable {
    private static final long serialVersionUID = 3353423729980581146L;
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码，加密存储
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 注册手机号
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 注册邮箱
     */
    @Column(name = "email")
    private String email;

    @Column(name = "imge")
    private String imge;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;

    /**
     * 是否删除
     */
    @Column(name = "user_del")
    private Integer userDel;


    private List<TbRole> roleList;
}