package com.manager.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
*@author sunli
* @date 2020/3/15 15:50
*/  
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "dormitoryexchangerecord")
public class Dormitoryexchangerecord implements Serializable {


    private static final long serialVersionUID = -4027185359666728173L;

    @Id
    @Column(name = "der_id")
    @GeneratedValue(generator = "JDBC")
    private Integer derId;

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
     * 原宿舍楼号
     */
    @Column(name = "old_floor_name")
    private String oldFloorName;

    /**
     * 原宿舍宿舍号
     */
    @Column(name = "old_hos_name")
    private String oldHosName;

    /**
     * 新宿舍楼号
     */
    @Column(name = "new_floor_name")
    private String newFloorName;

    /**
     * 新宿舍宿舍号
     */
    @Column(name = "new_hos_name")
    private String newHosName;

    /**
     * 宿舍调换原因
     */
    @Column(name = "detail")
    private String detail;

    /**
     * 记录时间
     */
    @Column(name = "recod_time")
    private Date recodTime;

    /**
     * 是否删除
     */
    @Column(name = "der_del")
    private Integer derDel;


}