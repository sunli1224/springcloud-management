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
 * 楼宇管理DTO
 * @author sunli
 * @date 2020/4/21 14:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class floorDto implements Serializable {

    private static final long serialVersionUID = 8618714159855364521L;

    /**
     * 宿舍楼序号
     */
    @Column(name = "floor_id")
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
     * 员工号
     */
    @Column(name = "emp_num")
    private String empNum;

    /**
     * 员工姓名
     */
    @Column(name = "emp_name")
    private String empName;

    /**
     * 员工手机号
     */
    @Column(name = "emp_phone")
    private String empPhone;

//    /**
//     * 是否删除
//     */
//    @Column(name = "floor_del")
//    private Integer floorDel;
}
