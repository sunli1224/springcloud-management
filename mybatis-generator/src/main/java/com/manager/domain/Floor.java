package com.manager.domain;

import java.io.Serializable;
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
@Table(name = "`floor`")
public class Floor implements Serializable {
    /**
     * 宿舍楼序号
     */
    @Id
    @Column(name = "floor_id")
    @GeneratedValue(generator = "JDBC")
    private Integer floorId;

    /**
     * 宿舍楼名称
     */
    @Column(name = "floor_name")
    private String floorName;

    /**
     * 宿舍楼介绍
     */
    @Column(name = "floor_detail")
    private String floorDetail;

    /**
     * 是否删除
     */
    @Column(name = "floor_del")
    private Integer floorDel;

    private static final long serialVersionUID = 1L;
}