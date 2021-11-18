package org.jeecg.modules.testExcel.enpojo;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-17
 * @Description:
 */
public class testEnum {

    static String PATH="E:/easyExcel";
    public static void main(String[] args) throws IOException {
        List<EnumDataEntity> list = new ArrayList<EnumDataEntity>();
        for (int i = 0; i < 100; i++) {
            EnumDataEntity client = new EnumDataEntity();
            client.setName("小明" + i);
            client.setSex(Sex.MAN);
            client.setStatus(StatusEnum.Init);
            client.setBaseStatus(StatusEnum.Ready);
            list.add(client);
        }
        Date start = new Date();
        ExportParams params = new ExportParams("枚举测试", "测试", ExcelType.XSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(params, EnumDataEntity.class, list);
        System.out.println(new Date().getTime() - start.getTime());
        FileOutputStream fos = new FileOutputStream(PATH+"/测试表.xlsx");
        workbook.write(fos);
        fos.close();
    }
}
