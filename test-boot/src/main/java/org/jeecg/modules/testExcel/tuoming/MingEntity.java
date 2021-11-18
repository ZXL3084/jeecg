package org.jeecg.modules.testExcel.tuoming;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-17
 * @Description:
 */
@Data
public class MingEntity {

    @Excel(name = "姓名", desensitizationRule = "1,6")
    private String name;
    @Excel(name = "身份证", desensitizationRule = "6_4")
    private String card;
    @Excel(name = "手机号", desensitizationRule = "3_4")
    private String phone;
    @Excel(name = "邮箱", desensitizationRule = "3~@")
    private String email;
}


