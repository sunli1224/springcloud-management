package com.manager.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
*@author sunli
* @date 2020/4/20 3:40
*/  
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "record")
public class Record implements Serializable {
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

    private static final long serialVersionUID = 1L;
}