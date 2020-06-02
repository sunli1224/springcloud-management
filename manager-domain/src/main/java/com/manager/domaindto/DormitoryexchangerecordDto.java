package com.manager.domaindto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author sunli
 * @date 2020/4/24 0:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DormitoryexchangerecordDto implements Serializable {

    private static final long serialVersionUID = -8026100088932092023L;


    @Column(name = "der_id")
    private Integer derId;

    /**
     * 学生学号
     */
    @Column(name = "stu_num")
    @NotBlank(message = "学号不能为空")
    private String stuNum;

    /**
     * 学生姓名
     */
    @Column(name = "stu_name")
    @NotBlank(message = "姓名不能为空")
    private String stuName;

    /**
     * 原宿舍楼号
     */
    @Column(name = "old_floor_name")
    @NotBlank(message = "楼号不能为空")
    private String oldFloorName;

    /**
     * 原宿舍宿舍号
     */
    @Column(name = "old_hos_name")
    @NotBlank(message = "宿舍号不能为空")
    private String oldHosName;

    /**
     * 新宿舍楼号
     */
    @Column(name = "new_floor_name")
    @NotBlank(message = "宿舍号不能为空")
    private String newFloorName;

    /**
     * 新宿舍宿舍号
     */
    @Column(name = "new_hos_name")
    @NotBlank(message = "宿舍号不能为空")
    private String newHosName;

    /**
     * 宿舍调换原因
     */
    @Column(name = "detail")
    @NotBlank(message = "调换原因不能为空")
    private String detail;

    /**
     * 记录时间
     */
    // yyyy-MM-dd HH:mm:ss
    @Column(name = "recod_time")
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date recodTime;
}
