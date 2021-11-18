package org.jeecg.modules.testExcel.pull;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.handler.inter.IExcelDataHandler;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecg.modules.testExcel.CourseEntity;
import org.jeecg.modules.testExcel.enpojo.Sex;
import org.jeecg.modules.testExcel.handler.ExcelDiceAddressListHandlerImpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-17
 * @Description:
 */
public class testPull {

    static String PATH="E:/easyExcel";
    public static void main(String[] args) throws IOException {
        List<PullEntity> pullEntities=new ArrayList<>();

        PullEntity pullEntity = new PullEntity();
        pullEntity.setName("小明1");
        pullEntity.setSex(Sex.MAN);
        pullEntity.setBilibili(0);
        pullEntity.setStatus("初始化");
        pullEntities.add(pullEntity);

        PullEntity pullEntity2=new PullEntity();
        pullEntity2.setName("小明2");
        pullEntity2.setSex(Sex.MAN);
        pullEntity2.setBilibili(0);
        pullEntity2.setStatus("初始化");
        pullEntities.add(pullEntity2);

        PullEntity pullEntity3=new PullEntity();
        pullEntity3.setName("小明3");
        pullEntity3.setSex(Sex.MAN);
        pullEntity3.setBilibili(0);
        pullEntity3.setStatus("初始化");
        pullEntities.add(pullEntity3);
        ExportParams exportParams = new ExportParams("下拉测试", "下拉", ExcelType.XSSF);
        exportParams.setDictHandler(new ExcelDiceAddressListHandlerImpl());
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams,
                PullEntity.class, pullEntities);

        FileOutputStream outputStream=new FileOutputStream(PATH+"/下拉表.xlsx");

        workbook.write(outputStream);

        //关闭流
        outputStream.close();
        System.out.println("下拉表---构建完成");

    }
}
