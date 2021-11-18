package org.jeecg.modules.testExcel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-15
 * @Description:
 */
@Data
@ExcelTarget("PersonEntity")
public class PersonEntity {

    /**
     * 名字
     */
    @Excel(name = "学生姓名", height = 20, width = 30, isImportField = "true_st",orderNum = "1")
    private String name;

    /**
     * 性别
     */
    @Excel(name = "学生性别", replace = { "男_1", "女_2" }, suffix = "生", isImportField = "true_st",orderNum = "2")
    private String sex;

    /**
     * 生日
     */
    @Excel(name = "出生日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd", isImportField = "true_st", width = 20,orderNum = "3")
    private Date birth;

}
