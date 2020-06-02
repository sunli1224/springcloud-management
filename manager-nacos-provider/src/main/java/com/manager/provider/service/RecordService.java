package com.manager.provider.service;

import com.manager.domaindto.RecordDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 缺勤记录模块
 * @author sunli
 * @date 2020/5/6 15:58
 */
public interface RecordService {
    /**
     * 查询所有缺勤记录
     * @return 缺勤记录集合
     * @throws Exception
     */
    public List<RecordDto> selectAllRecordInfo() throws Exception;

    /**
     * 分页服务
     * @param ids 分页
     * @return 分页数据map集合
     */
    public Map<String,Object> getAllRecordInfoPagingService(Integer ids);

    /**
     * 删除缺勤记录
     * @param id 缺勤记录id
     * @return 是否成功
     * @throws Exception
     */
    Boolean delRecordInfoByRecordId(Integer id) throws Exception;

    /**
     * 单个删除缺勤记录服务
     * @param id 缺勤id
     * @return 是否删除成功
     * @throws Exception
     */
    Boolean delOneRecordService(Integer id);

    /**
     * 删除多条记缺勤录服务
     * @param idList 缺勤id集合
     * @return 是否删除成功
     */
    Boolean delSomeRecordService(List<Integer> idList);


    /**
     * 添加一条记录
     * @param recordDto record对象
     * @return 是否添加成功
     * @throws Exception
     */
    Boolean insertOneRecordInfo(RecordDto recordDto)throws Exception;

    /**
     * 添加记录信息服务
     * @param recordDto record对象
     * @return 是否添加成功
     * @throws Exception
     */
    Boolean insertOneService(RecordDto recordDto);

    /**
     * 更新一条record记录
     * @param recordDto record对象
     * @return 是否更新成功
     * @throws Exception
     */
    Boolean updateOneRecordInfo(RecordDto recordDto) throws Exception;

    /**
     * 更新缺勤记录信息
     * @param recordDto record对象
     * @return 是否更新成功
     * @throws Exception
     */
    Boolean updateOneRecordInfoService(RecordDto recordDto);


}
