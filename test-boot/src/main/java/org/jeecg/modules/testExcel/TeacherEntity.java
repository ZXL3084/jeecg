package org.jeecg.modules.testExcel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-15
 * @Description:
 */
@Data
@ExcelTarget("TeacherEntity")
public class TeacherEntity {

    /**
     * 老师名
     */
    @Excel(name = "老师名", width = 25, isImportField = "true_absent",orderNum = "1",needMerge = true)
    private String teacherName;

}
