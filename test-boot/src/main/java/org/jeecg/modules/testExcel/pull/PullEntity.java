package org.jeecg.modules.testExcel.pull;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import org.jeecg.modules.testExcel.enpojo.Sex;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-17
 * @Description:
 */
@Data
public class PullEntity {
    @Excel(name = "名字")
    private String name;
    @Excel(name = "性别")
    private Sex sex;
    @Excel(name = "B站登记", dict = "level", addressList = true)
    private int    bilibili;
    @Excel(name = "状态", replace = {"初始化_0", "正常_1", "注销_2"}, addressList = true)
    private String status;
}
