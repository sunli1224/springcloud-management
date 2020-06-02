package com.manager.provider.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.commons.HttpStatus;
import com.manager.commons.PageHelperUtils;
import com.manager.domain.Floor;
import com.manager.domaindto.floorDto;
import com.manager.exception.PageHelperException;
import com.manager.exception.floorException;
import com.manager.mapper.FloorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunli
 * @date 2020/3/15 17:16
 */
@Service
public class floorServiceImpl implements floorService {

    @Autowired
    private FloorMapper floorMapper;

    @Override
    public Integer getInfoPrimaryKey(String floorName) throws Exception {
        Example e = new Example(Floor.class);
        e.createCriteria().andEqualTo("floorName",floorName);
        return floorMapper.selectOneByExample(e).getFloorId();
    }

    /**
     *  查询所有楼宇表
     * @return List<Floor>
     * @throws Exception
     */
    @Override
    public List<Floor> getAllFloorList() throws Exception {
        return floorMapper.selectAll();
    }

    /**
     * 查询楼宇根据楼宇的名称
     * @param floorName 楼宇名称
     * @return List<Floor>
     * @throws Exception
     */
    @Override
    public List<Floor> getFloorByFloorName(String floorName) throws Exception {
        Example e = new Example(Floor.class);
        e.createCriteria().andEqualTo("floorName",floorName);
        return floorMapper.selectByExample(e);
    }


    /**
     * 查询所有楼宇的信息
     * 楼宇表和员工表的联表查询
     * @return 返回全部的楼宇信息
     * @throws Exception
     */
    @Override
    public List<floorDto> selectAllFloorListInfo() throws Exception {
        return floorMapper.selectAllFloorListInfo();
    }

    /**
     * 查询楼宇信息的服务
     * @return 返回楼宇信息的Map集合
     * @throws Exception
     */
    @Override
    public Map<String, Object> selectAllFloorListService() throws Exception {
        Map<String,Object> map = new HashMap<>();
        try {
            map.put("floorInfoList",this.selectAllFloorListInfo());

        } catch (Exception e) {
            throw new floorException(HttpStatus.TP_FAILED,"请求失败");
        }
        return map;
    }

    /**
     * 删除单个楼宇信息
     * @return 删除是否成功
     * @throws Exception
     */
    @Override
    public Boolean delOneFloorInfo(Integer id) throws Exception {
        return floorMapper.delOneFloorInfo(id);
    }

    /**
     * 删除单个楼宇服务
     * @param id 楼宇id
     * @return 删除是否成功
     * @throws Exception
     */
    @Override
    public Boolean delOneFloorInfoService(Integer id) throws Exception {
        Boolean judge;
        if (id != null) {
            try {
                judge = this.delOneFloorInfo(id);
                if (judge) {
                    return true;
                }
            } catch (Exception e) {
                throw new floorException(HttpStatus.TP_FAILED,"请求失败");
            }
        }
        return false;
    }

    /**
     * 删除多个楼宇服务
     * @param idList 楼宇id集合
     * @return 删除是否成功
     * @throws Exception
     */
    @Override
    public Boolean delAllFloorInfoListService(List<Integer> idList) throws Exception {
        if (idList.size() != 0) {
            idList.forEach(item -> {
                try {
                    this.delOneFloorInfo(item);
                } catch (Exception e) {
                    throw new floorException(HttpStatus.TP_FAILED,"请求失败");
                }
            });
            return true;
        }
        return false;
    }

    /**
     * 根据楼宇名字来查询对应的楼宇信息集合
     * @param floorName 楼宇名
     * @return 楼宇信息集合
     * @throws Exception
     */
    @Override
    public List<floorDto> selectFloorListByFloorName(String floorName) throws Exception {
        return floorMapper.selectFloorListByFloorName(floorName);
    }

    /**
     * 根据楼宇名进行查询服务
     * @param floorName 楼宇名
     * @return 楼宇信息集合
     * @throws Exception
     */
    @Override
    public Map<String,Object> selectFloorInfoByFloorNameService(String floorName) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<floorDto> floorDtos = null;
        if (floorName != null) {
            floorDtos = this.selectFloorListByFloorName(floorName);
            map.put("floorList",floorDtos);
        }
        return map;
    }

    /**
     * 插入一条楼宇信息数据
     * @param floor 楼宇对象
     * @return 是否插入成功
     * @throws Exception
     */
    @Override
    public Boolean insertFloorInfo(Floor floor) throws Exception {
        return floorMapper.insertFloorInfo(floor);
    }


    /**
     * 插入楼宇信息服务
     * @param floor 楼宇对象
     * @return 是否插入成功
     */
    @Override
    public Boolean insertFloorInfoService(Floor floor){
        Boolean judge = null;
        if (floor != null) {
            try {
                judge = this.insertFloorInfo(floor);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return judge;
        }
        return false;
    }

    /**
     * 查询所有没有楼宇管理员的楼宇名称集合
     * @return 楼宇名称集合
     */
    @Override
    public List<floorDto> selectFloorIdNoFloorManager() throws Exception {
        return floorMapper.selectFloorIdNoFloorManager();
    }

    /**
     * 查询所有没有楼宇管理员的楼宇名称集合服务
     * @return 楼宇名称Map集合
     */
    @Override
    public Map<String, Object> selectFloorIdNoFloorManagerService() throws Exception {
        Map<String,Object> map = new HashMap<>();
         map.put("nofloorNameList",this.selectFloorIdNoFloorManager());
        return map;
    }

    /**
     * 楼宇管理分页服务
     * @param ids 页数
     * @return 分页后的集合
     * @throws Exception
     */
    @Override
    public Map<String, Object> floorInfoPaging(Integer ids){
        List<floorDto> floorList = null;
        Map<String,Object> map = null;
        try {
            map = new HashMap<>();
            PageHelper.startPage(ids, 12);
            floorList = this.selectAllFloorListInfo();
            PageInfo page = new PageInfo(floorList);
            // 当前请求第几页
            map.put("pageNum",page.getPageNum());
            // 总页数
            map.put("pageSize",page.getPageSize());
            // 首页页数
            map.put("isFirstPage",page.isIsFirstPage());
            // 尾页页数
            map.put("isLastPage",page.isIsLastPage());
            // 当前页数的数据
            map.put("stuList",floorList);
            // 查询所有数据的数量
            map.put("recordNum",page.getTotal());
        } catch (Exception e) {
            throw new PageHelperException(HttpStatus.TP_FAILED,"分页服务失败");
        }
        return map;
    }

    @Override
    public Boolean updateFloorInfo(floorDto floorDto) throws Exception {
        return floorMapper.updateFloorInfo(floorDto);
    }

    @Override
    public Boolean updateFloorInfoService(floorDto floorDto) {
        if (floorDto.getFloorId() != null) {
            try {
                if (this.updateFloorInfo(floorDto)) {
                    return true;
                }
            } catch (Exception e) {
                throw new floorException(HttpStatus.TP_FAILED,"请求失败");
            }
        }
        return false;
    }


}
