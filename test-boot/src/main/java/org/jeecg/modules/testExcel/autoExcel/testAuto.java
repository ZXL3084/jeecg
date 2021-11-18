package org.jeecg.modules.testExcel.autoExcel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecg.modules.testExcel.CourseEntity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-16
 * @Description:
 */
public class testAuto {

    static String PATH="E:/easyExcel";

    public static void main(String[] args) throws IOException {

//        List<ExcelExportEntity> entityList = new ArrayList<>();
//        //构造对象等同于@Excel
//        ExcelExportEntity excelentity = new ExcelExportEntity("姓名", "name");
//        excelentity.setNeedMerge(true);
//        entityList.add(excelentity);
//        entityList.add(new ExcelExportEntity("性别", "sex"));
//        excelentity = new ExcelExportEntity(null, "students");
//        List<ExcelExportEntity> temp = new ArrayList<>();
//        temp.add(new ExcelExportEntity("姓名", "name"));
//        temp.add(new ExcelExportEntity("性别", "sex"));
//        //构造List等同于@ExcelCollection
//        excelentity.setList(temp);
//        entityList.add(excelentity);
//
//
//        //map方式入参
//        List<Map<String, Object>> list = new ArrayList<>();
//        Map<String, Object> entityMap=new HashMap<>();
//        entityMap.put("name","张三");
//        entityMap.put("sex","2");
//
//        Map<String, Object> entityMap=new HashMap<>();
//        entityMap.put("name","张三");
//        entityMap.put("sex","2");
//
//        //把我们构造好的bean对象放到params就可以了
//        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("测试", "测试"), entityList,
//                list);
//        FileOutputStream fos = new FileOutputStream("D:/excel/ExcelExportForMap.tt.xls");
//        workbook.write(fos);
//        fos.close();


        List<ExcelExportEntity> entityList = new ArrayList<>();

        ExcelExportEntity exportEntity1=new ExcelExportEntity("姓名","name");
        exportEntity1.setOrderNum(1);
        exportEntity1.setWidth(30);

        ExcelExportEntity exportEntity2=new ExcelExportEntity("学生性别","sex");
        exportEntity2.setOrderNum(2);
        exportEntity2.setReplace(new String[]{"男_1", "女_2"});
        exportEntity2.setSuffix("生");
        exportEntity2.setWidth(20);

        entityList.add(exportEntity1);
        entityList.add(exportEntity2);

        //map方式入参
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> entityMap=new HashMap<>();
        entityMap.put("name","张三");
        entityMap.put("sex","2");

        Map<String, Object> entityMap2=new HashMap<>();
        entityMap2.put("name","李四");
        entityMap2.put("sex","1");

        list.add(entityMap);
        list.add(entityMap2);


        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
                entityList, list);

        FileOutputStream outputStream=new FileOutputStream(PATH+"/学生表.xlsx");

        workbook.write(outputStream);

        //关闭流
        outputStream.close();
        System.out.println("学生表---构建完成");






    }
}
