package com.manager.search.service;

import com.manager.domaindto.RecordDto;

import java.util.List;

/**
 * @author sunli
 * @date 2020/5/7 15:28
 */
public interface RecordSearchService {

    /**
     * 通过姓名搜索服务
     * @param stuName 姓名
     * @return 搜索结果
     */
    public List<RecordDto> searchRecordByStuName(String stuName);

    /**
     * 通过学号搜索
     * @param stuNumber 学号
     * @return 搜索结果
     */
    public List<RecordDto> searchRecordByStuNumber(String stuNumber);
}
