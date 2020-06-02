package com.manager.search.service;

import com.manager.commons.HttpStatus;
import com.manager.domaindto.DormitoryexchangerecordDto;
import com.manager.exception.HostelException;
import com.manager.mapper.DormitoryexchangerecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunli
 * @date 2020/5/8 3:16
 */
@Service
public class DorServiceImpl implements DorService {

    @Autowired
    private DormitoryexchangerecordMapper dorMapper;


    @Override
    public List<DormitoryexchangerecordDto> selectInfoByStuNumber(String stuNum) {
        if (stuNum !=null) {
            try {
                return dorMapper.selectDerInfoByStuNameOrStuNum(null,stuNum);
            } catch (Exception e) {
                throw new HostelException(HttpStatus.TP_FAILED,"查询失败");
            }

        }
        throw new HostelException(HttpStatus.TP_FAILED,"查询失败");
    }

    @Override
    public List<DormitoryexchangerecordDto> selectInfoByStuName(String stuName) {
        if (stuName !=null) {
            try {
                return dorMapper.selectDerInfoByStuNameOrStuNum(stuName,null);
            } catch (Exception e) {
                throw new HostelException(HttpStatus.TP_FAILED,"查询失败");
            }

        }
        throw new HostelException(HttpStatus.TP_FAILED,"查询失败");
    }
}
