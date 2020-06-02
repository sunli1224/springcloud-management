import com.alibaba.excel.support.ExcelTypeEnum;
import com.manager.commons.ExcelPoiUtil;
import com.manager.commons.ExcelUtil;
import com.manager.commons.QiNiuUtils;
import com.manager.commons.TimeUtils;
import com.manager.domaindto.StudentDto;
import com.manager.excelbean.StudentExcelBean;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.ehcache.impl.internal.classes.commonslang.ArrayUtils;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sunli
 * @date 2020/3/18 23:54
 */
public class Test01 {


    @Test
    public void test09() throws Exception {
        TimeUtils timeUtils = new TimeUtils();
        System.out.println(timeUtils.getLocalTime());
    }

    @Test
    public void test01()throws Exception {
        QiNiuUtils qiNiuUtils = new QiNiuUtils();
        String upload = qiNiuUtils.upload("E:\\springBootProject\\manager-spring-cloud-alibaba\\ImagePath\\123.xlsx"
                , "123.xlsx");
        System.out.println(upload);
    }

    @Test
    public void test2() {
        ExcelPoiUtil excelPoiUtil = new ExcelPoiUtil();
        List list = excelPoiUtil.readFileToList("E:\\springBootProject\\manager-spring-cloud-alibaba\\path\\", "complexHeadWrite1584552984699.xlsx", StudentExcelBean.class);
        list.forEach(System.out::println);
    }


    /**
     * easy excel 读
     * @throws Exception
     */
    @Test
    public void test7() throws Exception {
        try {
            InputStream inputStream=new FileInputStream("E:\\springBootProject\\manager-spring-cloud-alibaba\\ImagePath\\123.xlsx");
            //读入文件，每一行对应一个 Model，获取 Model 列表
            List<StudentExcelBean> objectList = ExcelUtil.readExcelWithModel(inputStream, StudentExcelBean.class, ExcelTypeEnum.XLSX);
            for(StudentExcelBean StudentExcelBean: objectList) {
                System.out.println(StudentExcelBean);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * easy excel 写
     * @throws Exception
     */
    @Test
    public void test5() throws Exception {
        List<StudentExcelBean> StudentExcelBeanList = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            StudentExcelBean StudentExcelBean = new StudentExcelBean();
            StudentExcelBean.setStuName("name" + i);
            StudentExcelBean.setStuSex(i + "");
            StudentExcelBean.setStuPhoneNumber("phone" + i);
            StudentExcelBean.setStuNum("stuNum" + i);
            StudentExcelBean.setStuClass("class" + i);
            StudentExcelBean.setStuFloor("floor" + i);
            StudentExcelBean.setStuHos("sax" + i);
            StudentExcelBean.setStuHos("perfession" + i);
            StudentExcelBeanList.add(StudentExcelBean);
        }

        // long beginTime = System.currentTimeMillis();
        OutputStream out = new FileOutputStream("E:\\springBootProject\\manager-spring-cloud-alibaba\\ImagePath\\123.xlsx");
        ExcelUtil.writeExcelWithModel(out, StudentExcelBeanList, StudentExcelBean.class, ExcelTypeEnum.XLSX);
        // long endTime = System.currentTimeMillis();
        // System.out.println(String.format("总共耗时 %s 毫秒", (endTime - beginTime)));

        //StudentExcelBeanList = null;
    }

    @Test
    public void test3() {
        ArrayList<StudentExcelBean> arr = new ArrayList<>();
        arr.add(new StudentExcelBean("12","122","122","122","122","122","122","122","12"));
        String excelPath = "E:\\springBootProject\\manager-spring-cloud-alibaba\\ImagePath\\";
        String excelName = "123.xlsx";
        ExcelPoiUtil excelPoiUtil = new ExcelPoiUtil();
        excelPoiUtil.writeFileFromList(excelPath,excelName,arr);
//        List list = excelPoiUtil.readFileToList(excelPath, excelName, StudentExcelBean.class);
//        list.forEach(System.out::println);
//        excelPoiUtil.writeFileFromList(excelPath,excelName,arr);
    }
        //    public static void main(String[] args) throws IOException {
//        ArrayList<StudentExcelBean> lists = new ArrayList<>();
//
//        for (int i = 0; i < 100 ; i++) {
//            StudentExcelBean stu = StudentExcelBean.builder()
//                    .stuNum("160310328")
//                    .stuName("张三")
//                    .stuSex("M")
//                    .stuProfession("计算机")
//                    .stuSess("2016")
//                    .stuPhoneNumber("13965543030")
//                    .stuClass("3班")
//                    .stuFloorId("3栋")
//                    .stuHosId(202).build();
//            lists.add(stu);
//        }
//        ExcelUtil.exportExcel(lists,StudentExcelBean.class);
//        System.out.println(FilenameUtils.getFullPath("test"));
//        File directory = new File("/path");//设定为当前文件夹
//        System.out.println(directory.getAbsolutePath());//获取标准的路径
//    }
}
