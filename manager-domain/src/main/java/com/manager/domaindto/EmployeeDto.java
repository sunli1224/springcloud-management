package com.manager.domaindto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author sunli
 * @date 2020/4/22 15:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {

    @Id
    @Column(name = "emp_id")
    private Integer empId;

    /**
     * 员工号
     */
    @Column(name = "emp_num")
    @NotBlank(message = "员工号不能为空")
    private String empNum;

    /**
     * 员工姓名
     */
    @Column(name = "emp_name")
    @NotBlank(message = "员工姓名不能为空")
    private String empName;

    /**
     * 员工性别
     */
    @Column(name = "emp_sex")
    @NotNull(message = "员工性别不能为空")
    private String empSex;

    /**
     * 员工年龄
     */
    @Column(name = "emp_age")
    @NotNull(message = "员工年龄不能为空")
    private Integer empAge;

    /**
     * 员工手机号
     */
    @Column(name = "emp_phone")
    @Pattern(regexp = "^1[3-578]\\d{9}$" ,message = "手机号不符合")
    @NotNull(message = "手机号不能为空")
    private String empPhone;

    /**
     * 员工住址
     */
    @Column(name = "emp_address")
    @NotNull(message = "员工住址不能为空")
    private String empAddress;

    /**
     * 员工职位
     */
    @Column(name = "emp_position")
    private String empPosition;

    /**
     * 宿舍楼名称
     */
    @Column(name = "floor_name")
    @NotNull(message = "宿舍楼不能为空")
    private String floorName;

    /**
     * 宿舍楼介绍
     */
    @Column(name = "floor_detail")
    private String floorDetail;
}
