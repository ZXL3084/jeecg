package org.jeecg.modules.config.handler;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-26
 * @Description:
 */
@Component
public class VideoResourceHttpRequestHandler extends ResourceHttpRequestHandler {   //请求处理


    @Override
    protected Resource getResource(HttpServletRequest request) throws IOException {
        return new ClassPathResource("videos/d3e8622b16678fee6d1329b8e20bab18_14001965640240750817.mp4");
    }
}
