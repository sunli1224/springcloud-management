package com.manager.provider.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.commons.HttpStatus;
import com.manager.domaindto.RecordDto;
import com.manager.exception.RecordException;
import com.manager.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunli
 * @date 2020/5/6 15:59
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;


    @Override
    public List<RecordDto> selectAllRecordInfo() throws Exception {
        return recordMapper.selectAllRecord();
    }

    @Override
    public Map<String, Object> getAllRecordInfoPagingService(Integer ids) {
        Map<String,Object> map = null;
        List<RecordDto> recordDtos = null;
        if (ids != null) {
            try {
                map = new HashMap<>();
                PageHelper.startPage(ids,12);
                recordDtos = this.selectAllRecordInfo();
                PageInfo page = new PageInfo(recordDtos);
                // 当前请求第几页
                map.put("pageNum",page.getPageNum());
                // 总页数
                map.put("pageSize",page.getPageSize());
                // 首页页数
                map.put("isFirstPage",page.isIsFirstPage());
                // 尾页页数
                map.put("isLastPage",page.isIsLastPage());
                // 当前页数的数据
                map.put("stuList",recordDtos);
                // 查询所有数据的数量
                map.put("recordNum",page.getTotal());
            } catch (Exception e) {
                throw new RecordException(HttpStatus.TP_FAILED,"分页失败");
            }
        }
        return map;
    }

    @Override
    public Boolean delRecordInfoByRecordId(Integer id) throws Exception {
        return recordMapper.delRecordInfoByRecordId(id);
    }

    @Override
    public Boolean delOneRecordService(Integer id) {
        if (id != null) {
            try {
                return this.delRecordInfoByRecordId(id);
            } catch (Exception e) {
                throw new RecordException(HttpStatus.TP_FAILED,"删除失败");
            }
        }
        return false;
    }

    @Override
    public Boolean delSomeRecordService(List<Integer> idList) {
        if (idList != null) {
            idList.forEach(this::delOneRecordService);
            return true;
        }
        return false;
    }

    @Override
    public Boolean insertOneRecordInfo(RecordDto recordDto) throws Exception {
        return recordMapper.insertOneRecordInfo(recordDto);
    }

    @Override
    public Boolean insertOneService(RecordDto recordDto){
        if (recordDto != null) {
            try {
                return this.insertOneRecordInfo(recordDto);
            } catch (Exception e) {
                throw new RecordException(HttpStatus.TP_FAILED,"请求失败");
            }
        }
        return false;
    }

    @Override
    public Boolean updateOneRecordInfo(RecordDto recordDto) throws Exception {
        return recordMapper.updateOneRecordInfo(recordDto);
    }

    @Override
    public Boolean updateOneRecordInfoService(RecordDto recordDto) {
        if (recordDto != null) {
            try {
                return this.updateOneRecordInfo(recordDto);
            } catch (Exception e) {
                throw new RecordException(HttpStatus.TP_FAILED,"更新失败");
            }
        }
        return false;
    }
}
