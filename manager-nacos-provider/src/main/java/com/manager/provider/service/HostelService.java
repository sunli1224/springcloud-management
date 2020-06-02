package com.manager.provider.service;

import com.manager.domain.Hostel;
import com.manager.domaindto.HostelDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 宿舍管理模块
 * @author sunli
 * @date 2020/4/23 16:49
 */
public interface HostelService {

    /**
     * 得到主键
     * @param hosNum 宿舍名
     * @return 主键
     * @throws Exception
     */
    Integer getOnePrimaryId(String hosNum) throws Exception;

    /**
     * 宿舍管理分页服务
     * @param ids 请求页数
     * @return 宿舍信息集合
     * @throws Exception
     */
    Map<String,Object> getHostelInfoPaging(Integer ids);

    /**
     * 查询所有宿舍相关信息
     * @return 宿舍信息集合
     * @throws Exception
     */
    List<HostelDto> selectHostelInfoList() throws Exception;

    /**
     * 查询所有宿舍相关信息服务
     * @return 宿舍信息集合map集合
     */
    Map<String,Object> getHostelInfoListService();


    /**
     * 插入一条新的宿舍信息
     * @param hostel 宿舍信息新的对象
     * @return 插入是否成功
     * @throws Exception
     */
    Boolean insertOneHostelInfo(Hostel hostel) throws Exception;

    /**
     * 插入一条宿舍信息服务
     * @param hostel 宿舍信息对象
     * @return 插入是否成功
     */
    Boolean insertOneHostInfoService(HostelDto hostel);

    /**
     * 查询该楼宇下所有的已经存在的宿舍号集合
     * @param floorName 楼宇名称
     * @return 该楼宇下所有的已经存在的宿舍号集合
     * @throws Exception
     */
    List<String> selectFloorHostelList(String floorName) throws Exception;

    /**
     * 查询该楼宇下所有的已经存在的宿舍号集合服务
     * @param floorName 楼宇名称
     * @return 该楼宇下所有的已经存在的宿舍号集合
     * @throws Exception
     */
    List<String> selectFloorHostelListService(String floorName);

    /**
     * 删除单个宿舍信息
     * @param hosId 宿舍楼id
     * @return 是否删除成功
     * @throws Exception
     */
    Boolean deleteHostelInfo(Integer hosId) throws Exception;

    /**
     * 删除单个宿舍信息服务
     * @param hosId 宿舍id
     * @return 是否删除成功
     * @throws Exception
     */
    Boolean deleteHostelInfoService(Integer hosId);

    /**
     * 删除多个宿舍信息服务
     * @param hosIdList 宿舍id集合
     * @return 是否删除成功
     */
    Boolean deleteSomeHostelInfoService(List<Integer> hosIdList);

    /**
     * 修改单个宿舍信息
     * @param hostel 修改宿舍对象
     * @return 修改是否成功
     * @throws Exception
     */
    Boolean updateHostelInfo(HostelDto hostel) throws Exception;

    /**
     * 修改单个宿舍信息服务
     * @param hostel 修改宿舍对象
     * @return 修改是否成功
     */
    Boolean updateHostelInfoService(HostelDto hostel);


    /**
     * 通过条件查询宿舍楼宇信息
     * @param hosId 宿舍信息id
     * @param floorName 楼宇名
     * @param hosNum 宿舍号
     * @return 查询所有宿舍楼宇信息
     * @throws Exception
     */
    HostelDto selectHostelFloorInfoByHosId(Integer hosId,String hosNum, String floorName) throws Exception;

}
