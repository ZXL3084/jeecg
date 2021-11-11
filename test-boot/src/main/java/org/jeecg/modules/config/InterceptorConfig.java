package org.jeecg.modules.config;


import org.jeecg.modules.ccKefu.interceptors.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-08-05
 * @Description:
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/ccKefu/getPageList")    //其它都需要验证
                .excludePathPatterns("/ccKefu/login");  //所有用户登录不拦截
    }
}
