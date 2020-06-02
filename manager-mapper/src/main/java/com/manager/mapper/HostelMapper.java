package com.manager.mapper;

import basemapper.BaseMapper;
import com.manager.domain.Hostel;
import com.manager.domaindto.HostelDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
*@author sunli
* @date 2020/3/17 16:25
*/  
public interface HostelMapper extends BaseMapper<Hostel> {
    /**
     * 查询所有宿舍相关信息
     * @return 宿舍信息集合
     * @throws Exception
     */
     List<HostelDto> selectHostelInfoList() throws Exception;


    /**
     * 插入一条新的宿舍信息
     * @param hostel 宿舍信息新的对象
     * @return 插入是否成功
     * @throws Exception
     */
     Boolean insertOneHostelInfo(Hostel hostel) throws Exception;

    /**
     * 查询该楼宇下所有的已经存在的宿舍号集合
     * @param floorName 楼宇名称
     * @return 该楼宇下所有的已经存在的宿舍号集合
     * @throws Exception
     */
     List<String> selectFloorHostelList(String floorName) throws Exception;


    /**
     * 删除单个宿舍信息
     * @param hosId 宿舍id
     * @return 是否删除成功
     * @throws Exception
     */
     Boolean deleteHostelInfo(@Param("hosId") Integer hosId) throws Exception;

    /**
     * 修改单个宿舍信息
     * @param hostel 修改宿舍对象
     * @return 修改是否成功
     * @throws Exception
     */
     Boolean updateHostelInfo(HostelDto hostel) throws Exception;

    /**
     * 查询宿舍信息通过过宿舍号或者楼宇名
     * @param hosNum 宿舍号
     * @param floorName 楼号
     * @return 宿舍信息集合
     * @throws Exception
     */
     List<HostelDto> selectHostelInfoByHosNumOrFloorName(@Param("hosNum")String hosNum,@Param("floorName")String floorName) throws Exception;


    /**
     * 增加宿舍人数
     * @param floorName 楼宇名
     * @param hosNum 宿舍名
     * @return
     * @throws Exception
     */
     Boolean updateAddHosNum(@Param("floorName")String floorName,@Param("hosNum") String hosNum)throws Exception;

    /**
     * 减少宿舍人数
     * @param floorName 楼宇名
     * @param hosNum 宿舍名
     * @return
     * @throws Exception
     */
     Boolean updateDelHosNum(@Param("floorName")String floorName,@Param("hosNum") String hosNum)throws Exception;

    /**
     * 通过楼宇名查询对应的宿舍集合
     * @param floorName 楼宇名
     * @return 宿舍号集合
     * @throws Exception
     */
     List<HostelDto> selectHosByFloorName(@Param("floorName") String floorName) throws Exception;

    /**
     * 从有剩余的寝室通过楼号查询
     * @param floorName 楼宇名
     * @return 宿舍集合
     * @throws Exception
     */
     List<HostelDto> selectRemaingHosByFloorName(@Param("floorName") String floorName) throws Exception;

    /**
     * 通过条件查询宿舍楼宇信息
     * @param hosId 宿舍信息id
     * @param floorName 楼宇名
     * @param hosNum 宿舍号
     * @return 查询所有宿舍楼宇信息
     * @throws Exception
     */
     HostelDto selectHostelFloorInfoByHosId(@Param("hosId") Integer hosId,@Param("hosNum") String hosNum, @Param("floorName") String floorName) throws Exception;
}