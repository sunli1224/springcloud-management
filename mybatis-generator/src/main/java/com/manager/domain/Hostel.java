package com.manager.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
*@author sunli
* @date 2020/4/23 16:48
*/  
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hostel")
public class Hostel implements Serializable {
    /**
     * 宿舍序号
     */
    @Id
    @Column(name = "hos_id")
    @GeneratedValue(generator = "JDBC")
    private Integer hosId;

    /**
     * 宿舍号
     */
    @Column(name = "hos_num")
    private String hosNum;

    /**
     * 已住人数
     */
    @Column(name = "hos_new_stu_num")
    private Integer hosNewStuNum;

    /**
     * 可住人数
     */
    @Column(name = "hos_old_stu_num")
    private Integer hosOldStuNum;

    /**
     * 楼号
     */
    @Column(name = "hos_floor_id")
    private Integer hosFloorId;

    /**
     * 是否删除
     */
    @Column(name = "hostel_del")
    private Integer hostelDel;

    private static final long serialVersionUID = 1L;
}