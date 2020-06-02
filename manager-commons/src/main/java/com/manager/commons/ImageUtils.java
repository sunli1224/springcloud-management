package com.manager.commons;

import com.google.common.base.Strings;

/**
 * @author sunli
 * @date 2020/5/14 15:08
 */
public class ImageUtils {

    /**
     * 判断文件是否为图片
     * @param fileName 文件名
     * @return 是否为图片
     */
    public static boolean isImageFile(String fileName){
        String[] img_type = new String[]{".jpg",".jpeg", ".png", ".gif", ".bmp"};
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
