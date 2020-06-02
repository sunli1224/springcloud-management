package com.manager.provider.service;

import com.manager.domain.Dormitoryexchangerecord;
import com.manager.domaindto.DormitoryexchangerecordDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 宿舍调换记录模块
 * @author sunli
 * @date 2020/4/24 0:21
 */
public interface DormitoryexchangerecordService {

    /**
     * 查询所有寝室调换信息
     * @return 寝室调换信息集合
     * @throws Exception
     */
    public List<DormitoryexchangerecordDto> selectAllDerInfoList()throws Exception;

    /**
     * 分页服务
     * @param ids 页号
     * @return 分页后map集合
     * @throws Exception
     */
    public Map<String,Object> derInfoPagingService(Integer ids);


    /**
     * 删除单个寝室调换信息
     * @param derId 寝室调换记录id
     * @return 是否删除成功
     * @throws Exception
     */
    public Boolean delOneDerInfoByDerId(Integer derId)throws Exception;

    /**
     * 删除一条记录
     * @param derId id
     * @return 是否删除成功
     */
    public Boolean delOneService(Integer derId);

    /**
     * 删除多条记录
     * @param idList id集合
     * @return 是否删除成功
     */
    public Boolean delSomeService(List<Integer> idList);


    /**
     * 插入一条寝室调换信息
     * @param dormitoryexchangerecordDto 寝室调换记录
     * @return 是否添加成功
     * @throws Exception
     */
    public Boolean insertOneDerInfo(DormitoryexchangerecordDto dormitoryexchangerecordDto)throws Exception;

    /**
     * 添加一条记录
     * @param dormitoryexchangerecordDto 记录信息
     * @return 是否添加成功
     */
    public Boolean insertOneService(DormitoryexchangerecordDto dormitoryexchangerecordDto);



    /**
     * 根据id更新寝室调换记录id
     * @param dormitoryexchangerecordDto dto对象
     * @return 是否更新成功
     * @throws Exception
     */
    public Boolean updateDerInfoByDerId(DormitoryexchangerecordDto dormitoryexchangerecordDto)throws Exception;

    /**
     * 更新寝室调换信息服务
     * @param dormitoryexchangerecordDto 更新信息对象
     * @return 是否更新成功
     */
    public Boolean updateDerInfoService(DormitoryexchangerecordDto dormitoryexchangerecordDto);

    /**
     * 通过id查询寝室调换信息
     * @param derId id
     * @return 结果
     * @throws Exception
     */
    public Dormitoryexchangerecord selectInfoByderId(Integer derId) throws Exception;
}
