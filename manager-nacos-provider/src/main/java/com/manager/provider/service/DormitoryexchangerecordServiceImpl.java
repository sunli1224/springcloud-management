package com.manager.provider.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.commons.HttpStatus;
import com.manager.domain.Dormitoryexchangerecord;
import com.manager.domain.Student;
import com.manager.domaindto.DormitoryexchangerecordDto;
import com.manager.domaindto.StudentDto;
import com.manager.exception.DormitoryexchangerecordException;
import com.manager.exception.HostelException;
import com.manager.exception.PageHelperException;
import com.manager.mapper.DormitoryexchangerecordMapper;
import com.manager.mapper.HostelMapper;
import com.manager.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 宿舍调换模块
 * @author sunli
 * @date 2020/4/24 0:22
 */
@Service
public class DormitoryexchangerecordServiceImpl implements DormitoryexchangerecordService {
    @Autowired
    private DormitoryexchangerecordMapper dormitoryexchangerecordMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private HostelMapper hostelMapper;

    @Override
    public List<DormitoryexchangerecordDto> selectAllDerInfoList() throws Exception {
        return dormitoryexchangerecordMapper.selectAllDerInfoList();
    }

    @Override
    public Map<String, Object> derInfoPagingService(Integer ids) {
            List<DormitoryexchangerecordDto> dtoList = null;
            Map<String,Object> map = null;
            try {
                if (ids != null) {
                    map = new HashMap<>();
                    PageHelper.startPage(ids, 12);
                    dtoList = this.selectAllDerInfoList();
                    PageInfo page = new PageInfo(dtoList);
//                    // 当前请求第几页
                    map.put("pageNum", page.getPageNum());
//                    // 总页数
                    map.put("pageSize", page.getPageSize());
//                    // 首页页数
                    map.put("isFirstPage", page.isIsFirstPage());
//                    // 尾页页数
                    map.put("isLastPage", page.isIsLastPage());
                    // 当前页数的数据
                    map.put("stuList", dtoList);
//                    // 查询所有数据的数量
                    map.put("recordNum", page.getTotal());
                }
                return map;
            } catch (Exception e) {
               throw new PageHelperException(HttpStatus.TP_FAILED,"分页失败");
            }
    }

    @Override
    public Boolean delOneDerInfoByDerId(Integer derId) throws Exception {
        return dormitoryexchangerecordMapper.delOneDerInfoByDerId(derId);
    }

    @Override
    public Boolean delOneService(Integer derId) {
        if (derId != null) {
            try {
                // 查询该学生的原宿舍记录以及现宿舍记录
                Dormitoryexchangerecord dor = this.selectInfoByderId(derId);
                studentMapper.updateStuInfoByStuNum(dor.getStuNum(), dor.getOldFloorName(), dor.getOldHosName());
                hostelMapper.updateAddHosNum(dor.getOldFloorName(), dor.getOldHosName());
                hostelMapper.updateDelHosNum(dor.getNewFloorName(), dor.getNewHosName());
                return this.delOneDerInfoByDerId(derId);
            } catch (Exception e) {
                throw  new HostelException(HttpStatus.TP_FAILED,"删除失败");
            }
        }
        return false;
    }

    @Override
    public Boolean delSomeService(List<Integer> idList) {
        if (idList != null) {
            idList.forEach(this::delOneService);
            return true;
        }
        return false;
    }

    @Override
    public Boolean insertOneDerInfo(DormitoryexchangerecordDto dormitoryexchangerecordDto) throws Exception {
        return dormitoryexchangerecordMapper.insertOneDerInfo(dormitoryexchangerecordDto);
    }

    @Override
    public Boolean insertOneService(DormitoryexchangerecordDto dor) {
        // 更新学生宿舍和楼宇信息
        try {
            if (dor != null ) {
                List<StudentDto> stuInfo = studentMapper.getStudnentListByStuNumber(dor.getStuNum());
                if (stuInfo.size() == 0) {
                    throw new DormitoryexchangerecordException(HttpStatus.TP_FAILED, "用户不存在");
                } else {
                    if (dor.getOldHosName().equals(stuInfo.get(0).getHosNum()) && dor.getOldFloorName().equals(stuInfo.get(0).getFloorName())) {
                        if (hostelMapper.selectHostelFloorInfoByHosId(null,dor.getNewHosName(),dor.getNewFloorName()) != null) {
                            studentMapper.updateStuInfoByStuNum(dor.getStuNum(), dor.getNewFloorName(), dor.getNewHosName());
                            hostelMapper.updateAddHosNum(dor.getNewFloorName(), dor.getNewHosName());
                            hostelMapper.updateDelHosNum(dor.getOldFloorName(), dor.getOldHosName());
                            return this.insertOneDerInfo(dor);
                        } else {
                            throw new DormitoryexchangerecordException(HttpStatus.TP_FAILED, "现宿舍号和现楼号不存在");
                        }
                    } else {
                        throw new DormitoryexchangerecordException(HttpStatus.TP_FAILED, "原宿舍号和原楼号不存在");
                    }
                }
            }
            return false;
        }
        catch (Exception e) {
            throw new HostelException(HttpStatus.TP_FAILED,"添加失败");
        }
    }

    @Override
    public Boolean updateDerInfoByDerId(DormitoryexchangerecordDto dormitoryexchangerecordDto) throws Exception {
        return dormitoryexchangerecordMapper.updateDerInfoByDerId(dormitoryexchangerecordDto);
    }

    @Override
    public Boolean updateDerInfoService(DormitoryexchangerecordDto dormitoryexchangerecordDto) {
        try {

            if (dormitoryexchangerecordDto.getDerId() != null) {
                if ("".equals(dormitoryexchangerecordDto.getDetail())) {
                    throw new DormitoryexchangerecordException(HttpStatus.TP_FAILED, "修改信息不能为空");
                }
                return this.updateDerInfoByDerId(dormitoryexchangerecordDto);
            }
            return false;
        }catch (Exception e) {
            throw new DormitoryexchangerecordException(HttpStatus.TP_FAILED, "更新失败");
        }
    }

    @Override
    public Dormitoryexchangerecord selectInfoByderId(Integer derId) throws Exception {
        Example e = new Example(Dormitoryexchangerecord.class);
        e.createCriteria().andEqualTo("derId",derId).andEqualTo("derDel",0);
        return dormitoryexchangerecordMapper.selectOneByExample(e);
    }


}
