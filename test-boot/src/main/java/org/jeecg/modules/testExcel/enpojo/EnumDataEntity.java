package org.jeecg.modules.testExcel.enpojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-17
 * @Description:
 */
@Data
public class EnumDataEntity {
    @Excel(name = "名字")
    private String name;
    @Excel(name = "性别")
    private Sex sex; //第一种
    @Excel(name = "基础状态")
    private StatusEnum baseStatus; //第二种
    @Excel(name = "状态", enumExportField = "message",
            enumImportMethod = "getByMessage")
    private StatusEnum status;//第三种
}
