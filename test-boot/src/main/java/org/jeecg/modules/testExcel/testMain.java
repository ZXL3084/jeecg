package org.jeecg.modules.testExcel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-15
 * @Description:
 */


public class testMain {


    static String PATH="E:/easyExcel";

    public static void main(String[] args) throws IOException {

        PersonEntity p1=new PersonEntity();
        p1.setSex("1");
        p1.setName("小明");
        p1.setBirth(new Date());
        PersonEntity p2=new PersonEntity();
        p2.setSex("2");
        p2.setName("小花");
        p2.setBirth(new Date());
        PersonEntity p3=new PersonEntity();
        p3.setSex("1");
        p3.setName("小华");
        p3.setBirth(new Date());

        List<PersonEntity> personEntityList=new ArrayList<>();
        personEntityList.add(p1);
        personEntityList.add(p2);
        personEntityList.add(p3);

        TeacherEntity teacherEntity=new TeacherEntity();
        teacherEntity.setTeacherName("王老师");

        TeacherEntity teacherEntity2=new TeacherEntity();
        teacherEntity2.setTeacherName("李老师");

        CourseEntity courseEntity=new CourseEntity();
        courseEntity.setCourseName("海贼王");
        courseEntity.setTeacher(teacherEntity);
        courseEntity.setPersonEntities(personEntityList);

        CourseEntity courseEntity2=new CourseEntity();
        courseEntity2.setCourseName("斗罗大陆");
        courseEntity2.setTeacher(teacherEntity2);
        courseEntity2.setPersonEntities(personEntityList);

        List<CourseEntity> courseEntities=new ArrayList<>();
        courseEntities.add(courseEntity);
        courseEntities.add(courseEntity2);

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班","课程"),
                CourseEntity .class, courseEntities);

        FileOutputStream outputStream=new FileOutputStream(PATH+"/课程表.xlsx");

        workbook.write(outputStream);

        //关闭流
        outputStream.close();
        System.out.println("课程表---构建完成");
    }
}
