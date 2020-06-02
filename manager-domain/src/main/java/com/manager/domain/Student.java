package com.manager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
*@author sunli
* @date 2020/3/18 18:13
*/  
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student implements Serializable {


    private static final long serialVersionUID = 8870548842726040021L;
    /**
     * 学生序号
     */
    @Id
    @Column(name = "stu_id")
    @GeneratedValue(generator = "JDBC")
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
    @Column(name = "stu_hos_id")
    private Integer stuHosId;

    /**
     * 楼号
     */
    @Column(name = "stu_floor_id")
    private Integer stuFloorId;

    /**
     * 是否删除
     */
    @Column(name = "stu_del")
    private Integer stuDel;
}