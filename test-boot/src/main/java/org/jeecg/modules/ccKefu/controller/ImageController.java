package org.jeecg.modules.ccKefu.controller;

import org.jeecg.modules.ccKefu.entity.Person;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-26
 * @Description:
 */
@RestController
@RequestMapping("/images")
public class ImageController {


    @GetMapping(value = "/image",produces ={MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_GIF_VALUE,MediaType.IMAGE_PNG_VALUE})
    public BufferedImage createImageDate() throws Exception{  //进行图像创建
        ClassPathResource classPathResource = new ClassPathResource("images/qiu.jpeg"); //资源加载
        return ImageIO.read(classPathResource.getInputStream()); //实现了文件的加载
    }
}
