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
* @date 2020/3/15 15:50
*/  
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`floor`")
public class Floor implements Serializable {

    private static final long serialVersionUID = -1712403536142836274L;

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


}