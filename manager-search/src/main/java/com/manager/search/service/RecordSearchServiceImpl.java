package com.manager.search.service;

import com.manager.commons.HttpStatus;
import com.manager.domaindto.RecordDto;
import com.manager.exception.RecordException;
import com.manager.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunli
 * @date 2020/5/7 15:28
 */
@Service
public class RecordSearchServiceImpl implements RecordSearchService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public List<RecordDto> searchRecordByStuName(String stuName) {
        if (stuName != null) {
            try {
                return recordMapper.selectRecordInfoByStuNameORStuNumber(null,stuName);
            } catch (Exception e) {
                throw new RecordException(HttpStatus.TP_FAILED,"搜索失败");
            }
        }
        throw new RecordException(HttpStatus.TP_FAILED,"搜索失败");
    }

    @Override
    public List<RecordDto> searchRecordByStuNumber(String stuNumber) {
        if (stuNumber != null) {
            try {
                return recordMapper.selectRecordInfoByStuNameORStuNumber(stuNumber,null);
            } catch (Exception e) {
                throw new RecordException(HttpStatus.TP_FAILED,"搜索失败");
            }
        }
        throw new RecordException(HttpStatus.TP_FAILED,"搜索失败");
    }
}
