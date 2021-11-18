package org.jeecg.modules.testExcel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-15
 * @Description:
 */
@Data
public class ImgEntity {

    /**
     * 图片名
     */
    @Excel(name = "学生姓名", width = 30, isImportField = "true_img",orderNum = "1")
    private String imgName;

    /**
     * url
     */
    @Excel(name = "图片",type = 2, width = 40, isImportField = "true_st",orderNum = "2",imageType = 1)
    private String url;

    /**
     * 描述
     */
    @Excel(name = "描述",orderNum = "3")
    private String context;
}
