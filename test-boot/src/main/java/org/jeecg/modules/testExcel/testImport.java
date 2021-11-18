package org.jeecg.modules.testExcel;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.jeecg.modules.testExcel.handler.MapImportHandler;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-16
 * @Description:
 */
public class testImport {

    public static void main(String[] args) {

        //信息导入
//        ImportParams params=new ImportParams();
//        params.setTitleRows(1);
//        params.setHeadRows(2);
//        List<CourseEntity> courseEntities= ExcelImportUtil.importExcel(new File("E:\\easyExcel\\课程表.xlsx"),CourseEntity.class,params);
//        System.out.println("导入进来的数据"+courseEntities.size());
//        if (!CollectionUtils.isEmpty(courseEntities)){
//            for (CourseEntity courseEntity : courseEntities) {
//                System.out.println(courseEntity);
//            }
//        }

        //图片导入

//        ImportParams params=new ImportParams();
//        params.setTitleRows(1);
//        params.setHeadRows(1);
//        params.setNeedSave(true);
//        params.setSaveUrl("E:/easyExcel");
//        List<ImgEntity> imgEntities =ExcelImportUtil.importExcel(new File("E:\\easyExcel\\图片表2.xlsx"),ImgEntity.class,params);
//        System.out.println("导入进来的数据"+imgEntities.size());
//        if (!CollectionUtils.isEmpty(imgEntities)){
//            for (ImgEntity imgEntity : imgEntities) {
//                System.out.println(imgEntity);
//            }
//        }


//        //map 导入
//        ImportParams params=new ImportParams();
//        params.setTitleRows(1);
//        params.setHeadRows(1);
//        List<Map<String,Object>> studentEntities= ExcelImportUtil.importExcel(new File("E:\\easyExcel\\学生表.xlsx"), Map.class,params);
//        System.out.println("导入进来的数据"+studentEntities.size());
//        if (!CollectionUtils.isEmpty(studentEntities)){
//            for (Map<String, Object> stringObjectMap : studentEntities) {
//                System.out.println("姓名为："+stringObjectMap.get("姓名")+"性别："+stringObjectMap.get("学生性别"));
//            }
//        }


        //使用自定义数据处理

        ImportParams params=new ImportParams();
        MapImportHandler importHandler=new MapImportHandler();
        params.setTitleRows(1);
        params.setHeadRows(1);
        importHandler.setNeedHandlerFields(new String[]{"课程名"});
        params.setDataHandler(importHandler);
        List<Map<String,Object>> studentEntities= ExcelImportUtil.importExcel(new File("E:\\easyExcel\\学生表.xlsx"), Map.class,params);
        System.out.println("导入进来的数据"+studentEntities.size());
        if (!CollectionUtils.isEmpty(studentEntities)){
            for (Map<String, Object> stringObjectMap : studentEntities) {
                System.out.println("姓名为："+stringObjectMap.get("name")+"性别："+stringObjectMap.get("sex"));
            }
        }


    }
}
