package org.jeecg.modules.testExcel.moreSheet;

import org.apache.commons.compress.utils.Lists;

import java.util.List;

//基础配置集合
public class ExportMoreView {
    private List<ExportView> moreViewList= Lists.newArrayList();

    public List<ExportView> getMoreViewList() {
        return moreViewList;
    }

    public void setMoreViewList(List<ExportView> moreViewList) {
        this.moreViewList = moreViewList;
    }
}
