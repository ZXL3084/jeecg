package org.jeecg.modules.ccKefu.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-29
 * @Description:
 */
@RestController
@RequestMapping("/pdf")
public class PDFController {

    @GetMapping("/getPdf")
    public void createPDFData(HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", "application/pdf"); //设置响应类型
        //一般情况下可以将生成的pdf文件进行下载，所以强制性下载，并配置下载的文件名称
        response.setHeader("Content-Disposition", "attachment;filename=test.pdf");
        //下面开始在内存中生成所需要的pdf文件
        Document document = new Document(PageSize.A4, 10, 10, 50, 50);  //主要设置页面的大小
        PdfWriter.getInstance(document, response.getOutputStream());//获取pdf输出流配置
        document.open(); //开始构建pdf文档
        //在当前的程序已经提供了图片的资源，所以利用资源匹配符进行资源路径定义
        ClassPathResource imageResource = new ClassPathResource("images/fengjing.jpg");  //spring所提供的资源访问
        Image image = Image.getInstance(imageResource.getFile().getAbsolutePath());//通过知道你路径加载图片
        //pdf文件在进行生成的时候是基于坐标的方式进行绘制的处理
        image.scaleToFit(PageSize.A4.getWidth() / 2, PageSize.A4.getHeight());
        float pointX = (PageSize.A4.getWidth() - image.getScaledWidth()) / 2;
        float pointY = PageSize.A4.getHeight() - image.getHeight() - 100;
        image.setAbsolutePosition(pointX, pointY);  //绘制坐标定义
        document.add(image);
        document.add(new Paragraph("\n\n\n"));  //换三行
        //如果想输出文字必须要有字体库
        ClassPathResource fontResource = new ClassPathResource("fonts/simkai.ttf");  //字体资源
        BaseFont baseFont = BaseFont.createFont(fontResource.getFile().getAbsolutePath(),
                BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font font = new Font(baseFont, 20, Font.NORMAL);
        //在pdf文件上绘制文字信息
        String[] title = new String[]{"自学", "pdf自动生成", "test"};
        String[] content = new String[]{"123456", "654321", "0000"};
        for (int i = 0; i < title.length; i++) {
            //实现数据的循环输出
            PdfPTable table = new PdfPTable(2);//定义表格
            PdfPCell cell = new PdfPCell();   //单元格信息
            cell.setPhrase(new Paragraph(title[i], font));  //输出文字定义
            table.addCell(cell);
            cell = new PdfPCell();
            cell.setPhrase(new Paragraph(content[i]));
            table.addCell(cell);
            document.add(table);
        }
        document.close();





    }

}
