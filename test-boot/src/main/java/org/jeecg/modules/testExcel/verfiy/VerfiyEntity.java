package org.jeecg.modules.testExcel.verfiy;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-17
 * @Description:
 */
@Data
public class VerfiyEntity {
    /**
     * Email校验
     */
    @Excel(name = "Email", width = 25)
    private String email;
    /**
     * 最大
     */
    @Excel(name = "Max")
    @Max(value = 15,message = "max 最大值不能超过15" ,groups = {ViliGroupOne.class})
    private int    max;
    /**
     * 最小
     */
    @Excel(name = "Min")
    @Min(value = 3, groups = {ViliGroupTwo.class})
    private int    min;
    /**
     * 非空校验
     */
    @Excel(name = "NotNull")
    @NotNull
    private String notNull;
    /**
     * 正则校验
     */
    @Excel(name = "Regex")
    @Pattern(regexp = "[\u4E00-\u9FA5]*", message = "不是中文")
    private String regex;
}
