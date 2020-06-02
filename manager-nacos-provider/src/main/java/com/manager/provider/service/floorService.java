package com.manager.provider.service;



import com.manager.domain.Floor;
import com.manager.domaindto.floorDto;

import java.util.List;
import java.util.Map;

/**
 * @author sunli
 * @date 2020/3/15 17:11
 */
public interface floorService {

    /**
     * 查主键
      * @param floorName 楼宇名
     * @return 返回主键
     * @throws Exception
     */
    Integer getInfoPrimaryKey(String floorName) throws Exception;

    /**
     *  查询所有楼宇
     * @return List<Floor>
     * @throws Exception
     */
    List<Floor> getAllFloorList() throws Exception;

    /**
     * 查询楼宇根据楼宇的名称
     * @param floorName 楼宇名称
     * @return List<Floor>
     * @throws Exception
     */
    List<Floor> getFloorByFloorName(String floorName) throws Exception;


    /**
     * 查询所有楼宇的信息
     * 楼宇表和员工表的联表查询
     * @return 返回全部的楼宇信息
     * @throws Exception
     */
    List<floorDto> selectAllFloorListInfo() throws Exception;

    /**
     * 查询楼宇信息的服务
     * @return 返回楼宇信息的Map集合
     * @throws Exception
     */
    Map<String,Object> selectAllFloorListService() throws Exception;


    /**
     * 删除单个楼宇信息
     * @param id 楼宇id
     * @return 删除是否成功
     * @throws Exception
     */
    Boolean delOneFloorInfo(Integer id) throws Exception;

    /**
     * 删除单个楼宇服务
     * @param id 楼宇id
     * @return 删除是否成功
     * @throws Exception
     */
    Boolean delOneFloorInfoService(Integer id) throws Exception;

    /**
     * 删除多个楼宇服务
     * @param idList 楼宇id集合
     * @return 删除是否成功
     * @throws Exception
     */
    Boolean delAllFloorInfoListService(List<Integer> idList) throws Exception;

    /**
     * 根据楼宇名字来查询对应的楼宇信息集合
     * @param floorName 楼宇名
     * @return 楼宇信息集合
     * @throws Exception
     */
    List<floorDto> selectFloorListByFloorName(String floorName) throws Exception;

    /**
     * 根据楼宇名进行查询服务
     * @param floorName 楼宇名
     * @return 楼宇信息集合
     * @throws Exception
     */
    Map<String,Object> selectFloorInfoByFloorNameService(String floorName) throws Exception;


    /**
     * 插入一条楼宇信息数据
     * @param floor 楼宇对象
     * @return 是否插入成功
     * @throws Exception
     */
    Boolean insertFloorInfo(Floor floor) throws Exception;


    /**
     * 插入楼宇信息服务
     * @param floor 楼宇对象
     * @return 是否插入成功
     * @throws Exception
     */
    Boolean insertFloorInfoService(Floor floor) throws Exception;


    /**
     * 查询所有没有楼宇管理员的楼宇名称集合
     * @return 楼宇名称集合
     */
    List<floorDto> selectFloorIdNoFloorManager() throws Exception;

    /**
     * 查询所有没有楼宇管理员的楼宇名称集合服务
     * @return 楼宇名称Map集合
     */
    Map<String,Object> selectFloorIdNoFloorManagerService() throws Exception;


    /**
     * 楼宇管理分页服务
     * @param ids 页数
     * @return 分页后的集合
     * @throws Exception
     */
    Map<String,Object> floorInfoPaging(Integer ids);


    /**
     * 更新楼宇信息
     * @param floorDto 楼宇对象
     * @return 是否更新成功
     * @throws Exception
     */
    Boolean updateFloorInfo(floorDto floorDto) throws Exception;

    /**
     * 更新楼宇信息服务
     * @param floorDto 楼宇对象
     * @return 是否更新成功
     * @throws Exception
     */
    Boolean updateFloorInfoService(floorDto floorDto);


}
