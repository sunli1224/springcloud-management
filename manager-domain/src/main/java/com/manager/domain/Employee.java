package com.manager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
*@author sunli
* @date 2020/4/21 14:21
*/  
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = -8669961261011458149L;
    /**
     * 员工序号
     */
    @Id
    @Column(name = "emp_id")
    @GeneratedValue(generator = "JDBC")
    private Integer empId;

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
     * 员工性别
     */
    @Column(name = "emp_sex")
    private String empSex;

    /**
     * 员工年龄
     */
    @Column(name = "emp_age")
    private Integer empAge;

    /**
     * 员工手机号
     */
    @Column(name = "emp_phone")
    @Pattern(regexp = "^1[3-578]\\d{9}$" ,message = "手机号不符合")
    private String empPhone;

    /**
     * 员工住址
     */
    @Column(name = "emp_address")
    private String empAddress;

    /**
     * 员工职位
     */
    @Column(name = "emp_position")
    private String empPosition;

    /**
     * 员工属于楼号
     */
    @Column(name = "emp_floor_id")
    private Integer empFloorId;

    /**
     * 是否删除
     */
    @Column(name = "emp_del")
    private Integer empDel;


}