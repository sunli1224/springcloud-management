package com.manager.excelbean;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * 学生表 excel JavaBean
 * @author sunli
 * @date 2020/3/18 17:38
 */
@Builder
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentExcelBean extends BaseRowModel implements Serializable {



    private final  static  String TABLENAME = "学生表" ;

    private static final long serialVersionUID = -3612504942458882762L;

    /**
     * 学生学号
     */
    @ExcelProperty(value = "学号" ,index = 0)
    private String stuNum;

    /**
     * 学生姓名
     */
    @ExcelProperty(value = "姓名" ,index = 1)
    private String stuName;

    /**
     * 学生性别
     */
    @ExcelProperty(value = "性别" ,index = 2)
    private String stuSex;

    /**
     * 学生专业
     */
    @ExcelProperty(value = "专业" ,index = 3)
    private String stuProfession;

    /**
     * 学生班级
     */
    @ExcelProperty(value = "班级" ,index = 4)
    private String stuClass;

    /**
     * 学生届数
     */
    @ExcelProperty(value = "届数" ,index = 5)
    private String stuSess;

    /**
     * 学生联系方式
     */
    @ExcelProperty(value = "联系方式" ,index = 6)
    private String stuPhoneNumber;

    /**
     * 楼号
     */
    @ExcelProperty(value = "楼号" ,index = 7)
    private String stuFloor;

    /**
     * 宿舍号
     */
    @ExcelProperty(value = "宿舍号" ,index = 8)
    private String stuHos;

}
