package com.manager.commons;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 分页工具类
 * @author sunli
 * @date 2020/4/30 1:18
 */
public class PageHelperUtils {

    /**
     * 分页初始化对象
     * @param ids 第几页
     * @param onePageNum 每页要设置多少条数据
     * @param list 分页对象
     * @return
     */
   public static PageInfo startPage(Integer ids, Integer onePageNum, List<?> list) {
       PageHelper.startPage(ids, onePageNum);
       return new PageInfo(list);
   }


//    // 查询的所有数据
//            map.put("recordNum",studentList.size());
//    // 当前请求第几页
//            map.put("pageNum",page.getPageNum());
//    // 总页数
//            map.put("pageSize",page.getPageSize());
//    // 首页页数
//            map.put("isFirstPage",page.isIsFirstPage());
//    // 尾页页数
//            map.put("isLastPage",page.isIsLastPage());
//    // 当前页数的数据
//            map.put("stuList",studentList);
}
