package com.manager.mapper;


import basemapper.BaseMapper;
import com.manager.domain.Dormitoryexchangerecord;
import com.manager.domaindto.DormitoryexchangerecordDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
*@author sunli
* @date 2020/3/15 15:50
*/
@Mapper
public interface DormitoryexchangerecordMapper extends BaseMapper<Dormitoryexchangerecord> {

    /**
     * 查询所有寝室调换信息
     * @return 寝室调换信息集合
     * @throws Exception
     */
    public List<DormitoryexchangerecordDto> selectAllDerInfoList()throws Exception;


    /**
     * 删除单个寝室调换信息
     * @param derId 寝室调换记录id
     * @return 是否删除成功
     * @throws Exception
     */
    public Boolean delOneDerInfoByDerId(@Param("derId") Integer derId)throws Exception;


    /**
     * 插入一条寝室调换信息
     * @param dormitoryexchangerecordDto 寝室调换记录
     * @return 是否添加成功
     * @throws Exception
     */
    public Boolean insertOneDerInfo(DormitoryexchangerecordDto dormitoryexchangerecordDto)throws Exception;

    /**
     * 根据学号或者姓名查询信息
     * @param stuName 姓名
     * @param stuNum 学号
     * @return 寝室调换信息集合
     * @throws Exception
     */
    public List<DormitoryexchangerecordDto> selectDerInfoByStuNameOrStuNum(@Param("stuName")String stuName,@Param("stuNum") String stuNum)throws Exception;


    /**
     * 根据id更新寝室调换记录id
     * @param dormitoryexchangerecordDto dto对象
     * @return 是否更新成功
     * @throws Exception
     */
    public Boolean updateDerInfoByDerId(DormitoryexchangerecordDto dormitoryexchangerecordDto)throws Exception;


}