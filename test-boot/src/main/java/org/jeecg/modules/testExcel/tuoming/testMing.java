package org.jeecg.modules.testExcel.tuoming;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecg.modules.testExcel.handler.ExcelDiceAddressListHandlerImpl;
import org.jeecg.modules.testExcel.pull.PullEntity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-17
 * @Description:
 */
public class testMing {

    static String PATH="E:/easyExcel";
    public static void main(String[] args) throws IOException {
        List<MingEntity> mingEntities=new ArrayList<>();
        MingEntity mingEntity=new MingEntity();
        mingEntity.setName("李四");
        mingEntity.setCard("432012422011247154");
        mingEntity.setPhone("17542184567");
        mingEntity.setEmail("1234512688@163.com");
        MingEntity mingEntity2=new MingEntity();
        mingEntity2.setName("李四");
        mingEntity2.setCard("432012422011247154");
        mingEntity2.setPhone("17542184567");
        mingEntity2.setEmail("1234512688@163.com");
        MingEntity mingEntity3=new MingEntity();
        mingEntity3.setName("李四");
        mingEntity3.setCard("432012422011247154");
        mingEntity3.setPhone("17542184567");
        mingEntity3.setEmail("1234512688@163.com");
        mingEntities.add(mingEntity);
        mingEntities.add(mingEntity2);
        mingEntities.add(mingEntity3);
        ExportParams exportParams = new ExportParams("脱敏测试", "脱敏", ExcelType.XSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams,
                MingEntity.class, mingEntities);

        FileOutputStream outputStream=new FileOutputStream(PATH+"/脱敏表.xlsx");

        workbook.write(outputStream);

        //关闭流
        outputStream.close();
        System.out.println("脱敏表---构建完成");
    }
}
