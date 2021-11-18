package org.jeecg.modules.testExcel.verfiy;

import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-17
 * @Description:
 */
public class VerifyEntityOfMode extends VerfiyEntity implements IExcelModel, IExcelDataModel {

    private String errorMsg;

    private Integer rowNum;

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public void setErrorMsg(String s) {
          this.errorMsg=s;
    }

    @Override
    public Integer getRowNum() {
        return rowNum;
    }

    @Override
    public void setRowNum(Integer integer) {
          this.rowNum=integer;
    }
}
