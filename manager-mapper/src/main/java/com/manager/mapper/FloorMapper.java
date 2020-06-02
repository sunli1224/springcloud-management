package com.manager.mapper;


import basemapper.BaseMapper;
import com.manager.domain.Floor;
import com.manager.domaindto.floorDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
*@author sunli
* @date 2020/3/15 15:50
*/
@Mapper
public interface FloorMapper extends BaseMapper<Floor> {
    /**
     * 查询所有楼宇的信息
     * 楼宇表和员工表的联表查询
     * @return 返回全部的楼宇信息
     * @throws Exception
     */
    List<floorDto> selectAllFloorListInfo() throws Exception;

    /**
     * 删除单个楼宇信息
     * @return 删除是否成功
     * @throws Exception
     */
    Boolean delOneFloorInfo(Integer id) throws Exception;

    /**
     * 根据楼宇名字来查询对应的楼宇信息集合
     * @param floorName 楼宇名
     * @return 楼宇信息集合
     * @throws Exception
     */
    List<floorDto> selectFloorListByFloorName(String floorName) throws Exception;

    /**
     * 插入一条楼宇信息数据
     * @param floor 楼宇对象
     * @return 是否插入成功
     * @throws Exception
     */
    Boolean insertFloorInfo(Floor floor) throws Exception;

    /**
     * 查找楼宇id
     * @param floorName 楼宇名
     * @return 楼宇id
     */
    Integer selectFloorIdByException(@Param("floorName") String floorName);

    /**
     * 查询所有没有楼宇管理员的楼宇名称集合
     * @return 楼宇名称集合
     */
    List<floorDto> selectFloorIdNoFloorManager() throws Exception;


    /**
     * 更新楼宇信息
     * @param floorDto 楼宇对象
     * @return 是否更新成功
     * @throws Exception
     */
    Boolean updateFloorInfo(floorDto floorDto) throws Exception;

}