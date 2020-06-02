package com.manager.domaindto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author sunli
 * @date 2020/4/23 17:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HostelDto implements Serializable {


    private static final long serialVersionUID = 3381031596262106521L;

    /**
     * 宿舍序号
     */
    @Column(name = "hos_id")
    private Integer hosId;

    /**
     * 宿舍号
     */
    @Column(name = "hos_num")
    @NotNull(message = "宿舍号不能空")
    private String hosNum;


    /**
     * 可住人数
     */
    @Column(name = "hos_old_stu_num")
    @NotNull(message = "已住人数不能为空")
    private Integer hosOldStuNum;

    /**
     * 已住人数
     */
    @Column(name = "hos_new_stu_num")
    private Integer hosNewStuNum;

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
     * 宿舍剩余人数
     */
    @Column(name = "remaining")
    private String remaining;

    /**
     * 楼号
     */
    @Column(name = "hos_floor_id")
    private Integer hosFloorId;
}
