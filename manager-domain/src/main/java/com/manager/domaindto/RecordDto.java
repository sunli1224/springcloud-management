package com.manager.domaindto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 缺勤记录dto
 * @author sunli
 * @date 2020/5/6 16:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecordDto implements Serializable {

    private static final long serialVersionUID = -3179211213181920284L;
    /**
     * 缺勤记录序号
     */
    @Column(name = "recod_id")
    private Integer recodId;

    /**
     * 学生学号
     */
    @Column(name = "stu_num")
    @NotBlank(message = "学生学号不能为空")
    private String stuNum;

    /**
     * 学生姓名
     */
    @Column(name = "stu_name")
    @NotBlank(message = "学生姓名不能为空")
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
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date recodTime;

    /**
     * 详情
     */
    @Column(name = "record_detail")
    @NotBlank(message = "详情不能为空")
    private String recordDetail;
}
