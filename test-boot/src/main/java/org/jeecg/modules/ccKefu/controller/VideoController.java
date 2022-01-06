package org.jeecg.modules.ccKefu.controller;

import org.jeecg.modules.config.handler.VideoResourceHttpRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-26
 * @Description:
 */
@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoResourceHttpRequestHandler videoResourceHttpRequestHandler;

    @GetMapping("/getVideo")
    public void creatVideoData(HttpServletRequest request, HttpServletResponse response)throws Exception{
        this.videoResourceHttpRequestHandler.handleRequest(request,response);
    }

}
