package com.manager.commons;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * @author sunli
 * @date 2020/5/9 3:24
 */
public class ExcelPoiUtil {
    /**
     * 从Excel文件中导出用户列表
     * @param excelPath: 当前文件路径
     * @param file: excel文件名
     * @param clazz: 实体类型
     * @return 实体集合
     */
    public  List readFileToList(String excelPath,String file,Class clazz){
        String excelFile = excelPath+file;
        ExcelReader reader = ExcelUtil.getReader(excelFile);
        List<Map<String,Object>> readAll = reader.readAll();
        //创建json数组
        JSONArray array = JSONUtil.createArray();

        for(Map<String,Object> map: readAll){
            JSONObject jsonObject = JSONUtil.createObj();
            Set<Map.Entry<String,Object>> entrys = map.entrySet();
            for(Map.Entry<String,Object> entry: entrys){
                jsonObject.put(entry.getKey(),entry.getValue());
            }
            array.add(jsonObject);
        }
        List result = JSON.parseArray(array.toString(),clazz);

        reader.close();//关闭流
        //reader.close();//关闭流
        return result;
    }

    /**
     * 把实体集合写入到Excel表。
     * @param excelPath 当前文件路径
     * @param file：要写入的Excel表。
     * @param objList：实体集合
     */
    public void writeFileFromList(String excelPath,String file,List objList){
        ArrayList<Map<String, Object>> rows = CollUtil.newArrayList();
        for(Object obj: objList){
            com.alibaba.fastjson.JSONObject jsonObject = (com.alibaba.fastjson.JSONObject) com.alibaba.fastjson.JSONObject.toJSON(obj);
            Map<String, Object> jsonMap = (Map<String,Object>) com.alibaba.fastjson.JSONObject.parse(jsonObject.toJSONString());
            rows.add(jsonMap);
        }
        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter(excelPath+file);
        // 合并单元格后的标题行，使用默认标题样式
        //writer.merge(row1.size() - 1, "一班成绩单");
        // 一次性写出内容，使用默认样式
        writer.write(rows);
        // 关闭writer，释放内存
        writer.close();
    }
}
