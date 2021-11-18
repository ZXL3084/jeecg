package org.jeecg.modules.testExcel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.util.List;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-15
 * @Description:
 */
@Data
@ExcelTarget("CourseEntity")
public class CourseEntity {

    /**
     * 课程名
     */
    @Excel(name = "课程名", width = 25, isImportField = "true",orderNum = "1",needMerge = true)
    private String courseName;

    @ExcelEntity(id = "absent")
    private TeacherEntity teacher;

    @ExcelCollection(name = "学生们",orderNum = "3")
    private List<PersonEntity> personEntities;





}
