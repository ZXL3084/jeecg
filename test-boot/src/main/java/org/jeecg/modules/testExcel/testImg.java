package org.jeecg.modules.testExcel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-15
 * @Description:
 */
public class testImg {

    static String PATH="E:/easyExcel";

    public static void main(String[] args) throws IOException {

        ImgEntity imgEntity=new ImgEntity();
        imgEntity.setImgName("秋天");
        imgEntity.setUrl("C:/Users/70723/Pictures/Camera Roll/qiu.jpeg");
        imgEntity.setContext("秋天美景");

        ImgEntity imgEntity2=new ImgEntity();
        imgEntity2.setImgName("山水");
        imgEntity2.setUrl("C:/Users/70723/Pictures/Camera Roll/shanshui.jpeg");
        imgEntity2.setContext("山水美景");


        ImgEntity imgEntity3=new ImgEntity();
        imgEntity3.setImgName("树");
        imgEntity3.setUrl("C:/Users/70723/Pictures/Camera Roll/shu.jpeg");
        imgEntity3.setContext("树美景");

        List<ImgEntity> imgEntities=new ArrayList<>();
        imgEntities.add(imgEntity);
        imgEntities.add(imgEntity2);
        imgEntities.add(imgEntity3);

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("图片描述","图片"),
                ImgEntity .class, imgEntities);

        FileOutputStream outputStream=new FileOutputStream(PATH+"/图片表2.xlsx");

        workbook.write(outputStream);

        //关闭流
        outputStream.close();
        System.out.println("图片表2---构建完成");



    }
}
