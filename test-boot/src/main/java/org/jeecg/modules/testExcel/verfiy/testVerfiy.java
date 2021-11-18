package org.jeecg.modules.testExcel.verfiy;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelImportEntity;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-17
 * @Description:
 */
public class testVerfiy {

    static String PATH="E:/easyExcel";
    public static void main(String[] args) throws Exception {

//        VerifyEntityOfMode verifyEntityOfMode=new VerifyEntityOfMode();
//        verifyEntityOfMode.setEmail("123456");
//        verifyEntityOfMode.setMax(10);
//        verifyEntityOfMode.setMin(10);
//        verifyEntityOfMode.setNotNull("zxl");
//        verifyEntityOfMode.setRegex("123");
//        VerifyEntityOfMode verifyEntityOfMode2=new VerifyEntityOfMode();
//        verifyEntityOfMode2.setEmail("123456");
//        verifyEntityOfMode2.setMax(123);
//        verifyEntityOfMode2.setMin(10);
//        verifyEntityOfMode2.setNotNull("zxl");
//        verifyEntityOfMode2.setRegex("123");
//        VerifyEntityOfMode verifyEntityOfMode3=new VerifyEntityOfMode();
//        verifyEntityOfMode3.setEmail("123456");
//        verifyEntityOfMode3.setMax(500);
//        verifyEntityOfMode3.setMin(10);
//        verifyEntityOfMode3.setNotNull("zxl");
//        verifyEntityOfMode3.setRegex("123");
//        List<VerifyEntityOfMode> verifyEntityOfModes=new ArrayList<>();
//        verifyEntityOfModes.add(verifyEntityOfMode);
//        verifyEntityOfModes.add(verifyEntityOfMode2);
//        verifyEntityOfModes.add(verifyEntityOfMode3);
//
//        Workbook workbook= ExcelExportUtil.exportExcel(new ExportParams("verfiy","校验"),VerifyEntityOfMode.class,verifyEntityOfModes);
//
//        FileOutputStream outputStream=new FileOutputStream(PATH+"/校验表.xlsx");
//
//        workbook.write(outputStream);
//
//        //关闭流
//        outputStream.close();
//        System.out.println("校验表---构建完成");

//        ImportParams params=new ImportParams();
//        params.setNeedVerify(true);
////        params.setVerifyGroup(new Class[]{ViliGroupOne.class});
////        params.setTitleRows(1);
////        params.setHeadRows(1);
//        ExcelImportResult<VerifyEntityOfMode> result= ExcelImportUtil.importExcelMore(
//                new FileInputStream("E:/easyExcel/校验表.xlsx"),VerifyEntityOfMode.class,params
//        );
//        FileOutputStream outputStream=new FileOutputStream(PATH+"/verfiy表.xlsx");
//
//        result.getWorkbook().write(outputStream);
//
//        //关闭流
//        outputStream.close();
//
//        System.out.println(result.getList().size()+"--------");

        ImportParams params=new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
//        params.setNeedVerify(true);
        List<VerifyEntityOfMode> modeList=ExcelImportUtil.importExcel(new File("E:/easyExcel/校验表.xlsx"),VerifyEntityOfMode.class,params);
        System.out.println("导入进来的数据"+modeList.size());

    }
}
