package com.manager.commons;

import com.google.common.base.Strings;

/**
 * @author sunli
 * @date 2020/5/30 3:32
 */
public class fileUtils {

    /**
     * 判断文件是否为Excel
     * @param fileName 文件名
     * @return 是否为Excel
     */
    public static boolean isExcelFile(String fileName){
        String[] img_type = new String[]{".xlsx"};
        if (Strings.isNullOrEmpty(fileName)){
            return false;
        }
        fileName = fileName.toLowerCase();

        for (String type : img_type){
            if (fileName.endsWith(type)){
                return true;
            }
        }

        return false;
    }


    /**
     * 获取文件后缀名
     * @param fileName 文件名
     * @return 返回文件结果
     */
    public static String getFileType(String fileName) {
        if(fileName!=null && fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf("."), fileName.length());
        }
        return "";
    }
}
