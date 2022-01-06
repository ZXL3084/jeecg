package org.jeecg.modules.ccKefu.controller;

import io.swagger.models.auth.In;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-25
 * @Description:
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @GetMapping("/downFile")
    public void fileDown(HttpServletResponse response) throws Exception {
        String fileName="实测实量检查项表模板.xlsx";
        response.setContentType("application/force-download");  //强制下载
        response.addHeader("Content-Disposition", "attachment;fileName="+ new String(fileName.getBytes(StandardCharsets.UTF_8),"ISO8859-1"));// 设置文件名
        ClassPathResource classPathResource = new ClassPathResource("excelFile/实测实量检查项表模板.xlsx"); //要下载的文件
        //要通过读取文件内容，随后一点点进行文件下载的操作
        InputStream inputStream = classPathResource.getInputStream();  //获取资源输入流
        byte[] buffer = new byte[1024];  //每次读取1024字节
        int len = 0;  //每次读取的个数
        while ((len = inputStream.read(buffer)) != -1) {
            response.getOutputStream().write(buffer, 0, len);
        }
    }

}
