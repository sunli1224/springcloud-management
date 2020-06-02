package com.manager.domaindto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 学生管理DTO
 * @author sunli
 * @date 2020/4/9 23:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDto implements Serializable {

    private static final long serialVersionUID = -8679356256354122872L;

    /**
     * 学生序号
     */
    @Column(name = "stu_id")
    private Integer stuId;

    /**
     * 学生学号
     */
    @Column(name = "stu_num")
    private String stuNum;

    /**
     * 学生姓名
     */
    @Column(name = "stu_name")
    private String stuName;

    /**
     * 学生性别
     */
    @Column(name = "stu_sex")
    private String stuSex;

    /**
     * 学生专业
     */
    @Column(name = "stu_profession")
    private String stuProfession;

    /**
     * 学生班级
     */
    @Column(name = "stu_class")
    private String stuClass;

    /**
     * 学生届数
     */
    @Column(name = "stu_sess")
    private String stuSess;

    /**
     * 学生联系方式
     */
    @Column(name = "stu_phone_number")
    private String stuPhoneNumber;

    /**
     * 宿舍号
     */
    @Column(name = "hos_num")
    private String hosNum;

    /**
     * 宿舍楼名称
     */
    @Column(name = "floor_name")
    private String floorName;

}
