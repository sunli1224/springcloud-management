package com.manager.search.service;

import com.manager.domain.Hostel;
import com.manager.domaindto.HostelDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sunli
 * @date 2020/5/7 20:41
 */
public interface HostelSearchService {
    /**
     * 通过宿舍号查询宿舍信息
     * @param hosNum 宿舍号
     * @return 宿舍信息集合
     */
    public List<HostelDto> searchHostelInfoByHostelNum(String hosNum);

    /**
     * 通过楼宇名查询宿舍信息
     * @param floorName 楼宇名
     * @return 宿舍信息集合
     */
    public List<HostelDto> searchHostelInfoByFloorName(String floorName);

    /**
     * 通过楼宇名查询对应的宿舍集合
     * @param floorName 楼宇名
     * @return 宿舍号集合
     * @throws Exception
     */
    public List<HostelDto> selectHosByFloorName(String floorName);

    /**
     * 从有剩余的寝室通过楼号查询
     * @param floorName 楼宇名
     * @return 宿舍集合
     * @throws Exception
     */
    List<HostelDto> selectRemaingHosByFloorName(String floorName);
}
