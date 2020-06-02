package com.manager.provider.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.commons.HttpStatus;
import com.manager.domain.Hostel;
import com.manager.domaindto.HostelDto;
import com.manager.exception.HostelException;
import com.manager.mapper.FloorMapper;
import com.manager.mapper.HostelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunli
 * @date 2020/4/23 16:50
 */
@Service
public class HostelServiceImpl implements HostelService {

    @Autowired
    private HostelMapper hostelMapper;

    @Autowired
    private FloorMapper floorMapper;

    @Override
    public Integer getOnePrimaryId(String hosNum) throws Exception {
        Example e = new Example(Hostel.class);
        e.createCriteria().andEqualTo("hosNum",hosNum);
        return hostelMapper.selectOneByExample(e).getHosId();
    }

    /**
     * 宿舍管理分页服务
     * @return 宿舍信息集合
     * @throws Exception
     */
    @Override
    public Map<String, Object> getHostelInfoPaging(Integer ids){
        List<HostelDto> hostelDtoList = null;
        Map<String,Object> map = null;
        try {
            map = new HashMap<>();
            PageHelper.startPage(ids,12);
            hostelDtoList = this.selectHostelInfoList();
            PageInfo page = new PageInfo(hostelDtoList);
            // 当前请求第几页
            map.put("pageNum",page.getPageNum());
            // 总页数
            map.put("pageSize",page.getPageSize());
            // 首页页数
            map.put("isFirstPage",page.isIsFirstPage());
            // 尾页页数
            map.put("isLastPage",page.isIsLastPage());
            // 当前页数的数据
            map.put("stuList",hostelDtoList);
            // 查询所有数据的数量
            map.put("recordNum",page.getTotal());
        } catch (Exception e) {
            throw new HostelException(HttpStatus.TP_FAILED,"分页服务失败");
        }
        return map;
    }

    /**
     * 查询所有宿舍相关信息
     * @return 宿舍信息集合
     * @throws Exception
     */
    @Override
    public List<HostelDto> selectHostelInfoList() throws Exception {
        return hostelMapper.selectHostelInfoList();
    }

    /**
     * 查询所有宿舍相关信息服务
     * @return 宿舍信息集合map集合
     */
    @Override
    public Map<String, Object> getHostelInfoListService() {
        Map<String,Object> map = new HashMap<>();
        List<HostelDto> hostelDtoList = null;
        try {
            hostelDtoList = this.selectHostelInfoList();
        } catch (Exception e) {
            throw new HostelException(HttpStatus.TP_FAILED,"请求超时");
        }
        map.put("hostelInfoList",hostelDtoList);
        return map;
    }

    /**
     * 插入一条新的宿舍信息
     * @param hostel 宿舍信息新的对象
     * @return 插入是否成功
     * @throws Exception
     */
    @Override
    public Boolean insertOneHostelInfo(Hostel hostel) throws Exception {
        return hostelMapper.insertOneHostelInfo(hostel);
    }


    /**
     * 插入一条宿舍信息服务
     * @param hostel 宿舍信息对象
     * @return 插入是否成功
     */
    @Override
    public Boolean insertOneHostInfoService(HostelDto hostel) {
        if (hostel != null) {
            if (this.selectFloorHostelListService(hostel.getFloorName()).contains(hostel.getHosNum())) {
                throw new HostelException(HttpStatus.TP_FAILED,"该宿舍号已经存在");
            } else {
                Integer floorId = floorMapper.selectFloorIdByException(hostel.getFloorName());
                try {
                    return this.insertOneHostelInfo(new Hostel(null,hostel.getHosNum(),null,null,floorId,null));
                } catch (Exception e) {
                    throw new HostelException(HttpStatus.TP_FAILED,"请求超时");
                }
            }
        }
        return false;
    }

    /**
     * 查询该楼宇下所有的已经存在的宿舍号集合
     * @param floorName 楼宇名称
     * @return 该楼宇下所有的已经存在的宿舍号集合
     * @throws Exception
     */
    @Override
    public List<String> selectFloorHostelList(String floorName) throws Exception {
        return hostelMapper.selectFloorHostelList(floorName);
    }


    /**
     * 查询该楼宇下所有的已经存在的宿舍号集合服务
     * @param floorName 楼宇名称
     * @return 该楼宇下所有的已经存在的宿舍号集合
     * @throws Exception
     */
    @Override
    public List<String> selectFloorHostelListService(String floorName) {
        List<String> floorHostelList;
        if (floorName != null) {
            try {
                floorHostelList = this.selectFloorHostelList(floorName);
            } catch (Exception e) {
                throw new HostelException(HttpStatus.TP_FAILED,"请求超时");
            }
            return floorHostelList;
        }
        throw new HostelException(HttpStatus.TP_FAILED,"请求超时");
    }

    /**
     * 删除单个宿舍信息
     * @param hosId 宿舍楼id
     * @return 是否删除成功
     * @throws Exception
     */
    @Override
    public Boolean deleteHostelInfo(Integer hosId) throws Exception {
        return hostelMapper.deleteHostelInfo(hosId);
    }


    /**
     * 删除单个宿舍信息服务
     * @param hosId 宿舍楼id
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteHostelInfoService(Integer hosId) {
        if (hosId != null) {
            try {
                return this.deleteHostelInfo(hosId);
            } catch (Exception e) {
                throw new HostelException(HttpStatus.TP_FAILED,"请求超时");
            }
        }
        return false;
    }

    /**
     * 删除多个宿舍信息服务
     * @param hosIdList 宿舍id集合
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteSomeHostelInfoService(List<Integer> hosIdList) {
        if (hosIdList.size() > 0) {
            hosIdList.forEach(this::deleteHostelInfoService);
            return true;
        }
        return false;
    }

    /**
     * 修改单个宿舍信息
     * @param hostel 修改宿舍对象
     * @return 修改是否成功
     * @throws Exception
     */
    @Override
    public Boolean updateHostelInfo(HostelDto hostel) throws Exception {
        return hostelMapper.updateHostelInfo(hostel);
    }

    /**
     * 修改单个宿舍信息服务
     * @param hostel 修改宿舍对象
     * @return 修改是否成功
     */
    @Override
    public Boolean updateHostelInfoService(HostelDto hostel){
        if (hostel.getHosId() != null) {
            try {
                HostelDto hostelInfo =this.selectHostelFloorInfoByHosId(hostel.getHosId(),null,null);
                if ("".equals(hostel.getFloorName()) && "".equals(hostel.getHosNum())) {
                    throw new HostelException(HttpStatus.TP_FAILED,"更新失败");
                }
                if (!"".equals(hostel.getFloorName()) && "".equals(hostel.getHosNum())) {
//                    if (hostelInfo.getFloorName().equals(hostel.getFloorName())) {
//                        throw new HostelException(HttpStatus.TP_FAILED,"填写的楼号与原楼号相同");
//                    }
                    if (this.selectHostelFloorInfoByHosId(null,hostelInfo.getHosNum(),hostel.getFloorName()) != null){
                        throw new HostelException(HttpStatus.TP_FAILED,"楼号与宿舍已经存在，无法更新");
                    }
                    Integer floorId = floorMapper.selectFloorIdByException(hostel.getFloorName());
                    hostel.setHosFloorId(floorId);
                    return this.updateHostelInfo(hostel);
                }
                if ("".equals(hostel.getFloorName()) && !"".equals(hostel.getHosNum())) {
                    if (this.selectHostelFloorInfoByHosId(null,hostel.getHosNum(),hostelInfo.getFloorName()) != null) {
                        throw new HostelException(HttpStatus.TP_FAILED,"楼号与宿舍已经存在，无法更新");
                    }
                    return this.updateHostelInfo(hostel);
                }
                if (!"".equals(hostel.getFloorName()) && !"".equals(hostel.getHosNum())) {
                    if (this.selectHostelFloorInfoByHosId(null,hostel.getHosNum(),hostel.getFloorName()) != null) {
                        throw new HostelException(HttpStatus.TP_FAILED,"楼号与宿舍已经存在，无法更新");
                    }
                    Integer floorId = floorMapper.selectFloorIdByException(hostel.getFloorName());
                    hostel.setHosFloorId(floorId);
                    return this.updateHostelInfo(hostel);
                }
            } catch (Exception e) {
                throw new HostelException(HttpStatus.TP_FAILED,"更新失败");
            }
        }
        return false;
    }

    @Override
    public HostelDto selectHostelFloorInfoByHosId(Integer hosId,String hosNum, String floorName) throws Exception {
        return hostelMapper.selectHostelFloorInfoByHosId(hosId, hosNum, floorName);
    }


}
