package com.manager.domain;

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
@Table(name = "record")
public class Record implements Serializable {

    private static final long serialVersionUID = -348187167256595568L;
    /**
     * 缺勤记录序号
     */
    @Id
    @Column(name = "recod_id")
    @GeneratedValue(generator = "JDBC")
    private Integer recodId;

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
     * 楼号
     */
    @Column(name = "floor_name")
    private String floorName;

    /**
     * 宿舍号
     */
    @Column(name = "hos_name")
    private String hosName;

    /**
     * 记录时间
     */
    @Column(name = "recod_time")
    private Date recodTime;

    /**
     * 详情
     */
    @Column(name = "record_detail")
    private String recordDetail;

    /**
     * 是否删除
     */
    @Column(name = "record_del")
    private Integer recordDel;

}