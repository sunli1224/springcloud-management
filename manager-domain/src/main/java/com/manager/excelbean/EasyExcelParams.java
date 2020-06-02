package com.manager.excelbean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author sunli
 * @date 2020/3/18 19:19
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class EasyExcelParams implements Serializable {
    /**
     * excel文件名（不带拓展名)
     */
    private String excelNameWithoutExt;
    /**
     * sheet名称
     */
    private String sheetName;

    /**
     * 数据
     */
    private List data;

    /**
     * 数据模型类型
     */
    private Class dataModelClazz;

//    /**
//     * 响应
//     */
//    private HttpServletResponse response;


//    public EasyExcelParams() {
//    }

//    /**
//     * 检查不允许为空的属性
//     *
//     * @return this
//     */
//    public EasyExcelParams checkValid() {
//        Assert.isTrue(ObjectUtils.allNotNull(excelNameWithoutExt, data, dataModelClazz, response), "导出excel参数不合法!");
//        return this;
//    }

}
