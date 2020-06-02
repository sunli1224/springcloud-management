package com.manager.mapper;


import basemapper.BaseMapper;
import com.manager.domain.Record;
import com.manager.domaindto.RecordDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
*@author sunli
* @date 2020/3/15 15:50
*/
@Mapper
public interface RecordMapper extends BaseMapper<Record> {
    /**
     * 查询所有缺勤记录
     * @return 缺勤记录集合
     * @throws Exception
     */
    List<RecordDto> selectAllRecord() throws Exception;

    /**
     * 删除缺勤记录
     * @param id 缺勤记录id
     * @return 是否成功
     * @throws Exception
     */
    Boolean delRecordInfoByRecordId(@Param("id") Integer id) throws Exception;


    /**
     * 添加一条记录
     * @param recordDto record对象
     * @return 是否添加成功
     * @throws Exception
     */
    Boolean insertOneRecordInfo(RecordDto recordDto)throws Exception;

    /**
     * 更新一条record记录
     * @param recordDto record对象
     * @return 是否更新成功
     * @throws Exception
     */
    Boolean updateOneRecordInfo(RecordDto recordDto) throws Exception;

    /**
     *
     * @param stuNumber 学号
     * @param stuName 学生姓名
     * @return
     * @throws Exception
     */
    List<RecordDto> selectRecordInfoByStuNameORStuNumber(@Param("stuNumber") String stuNumber,@Param("stuName") String stuName)throws Exception;
}