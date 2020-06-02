package com.manager.search.service;

import com.manager.commons.HttpStatus;
import com.manager.domaindto.HostelDto;
import com.manager.exception.HostelException;
import com.manager.mapper.HostelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 宿舍管理搜索服务
 * @author sunli
 * @date 2020/5/7 20:42
 */
@Service
public class HostelSearchServiceImpl implements HostelSearchService {

    @Autowired
    private HostelMapper hostelMapper;

    @Override
    public List<HostelDto> searchHostelInfoByHostelNum(String hosNum) {
        if (hosNum != null) {
            try {
                return hostelMapper.selectHostelInfoByHosNumOrFloorName(hosNum,null);
            } catch (Exception e) {
               throw new HostelException(HttpStatus.TP_FAILED,"搜索服务失败");
            }
        }
        throw new HostelException(HttpStatus.TP_FAILED,"搜索服务失败");
    }

    @Override
    public List<HostelDto> searchHostelInfoByFloorName(String floorName) {
        if (floorName != null) {
            try {
                return hostelMapper.selectHostelInfoByHosNumOrFloorName(null,floorName);
            } catch (Exception e) {
                throw new HostelException(HttpStatus.TP_FAILED,"搜索服务失败");
            }
        }
        throw new HostelException(HttpStatus.TP_FAILED,"搜索服务失败");
    }

    @Override
    public List<HostelDto> selectHosByFloorName(String floorName) {
        if (floorName != null) {
            try {
                return hostelMapper.selectHosByFloorName(floorName);
            } catch (Exception e) {
                throw new HostelException(HttpStatus.TP_FAILED, "搜索服务失败");
            }
        }
        throw new HostelException(HttpStatus.TP_FAILED,"搜索服务失败");
    }

    @Override
    public List<HostelDto> selectRemaingHosByFloorName(String floorName) {
        if (floorName != null) {
            try {
                return hostelMapper.selectRemaingHosByFloorName(floorName);
            } catch (Exception e) {
                throw new HostelException(HttpStatus.TP_FAILED, "搜索服务失败");
            }
        }
        throw new HostelException(HttpStatus.TP_FAILED, "搜索服务失败");
    }
}
