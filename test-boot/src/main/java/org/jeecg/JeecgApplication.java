package org.jeecg;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-03
 * @Description:
 */
@Slf4j
@SpringBootApplication(scanBasePackages = "util")
@MapperScan("org.jeecg.modules.ccKefu.mapper")
@EnableScheduling  //开启定时功能注解   缓存
@EnableCaching
//@EnableAsync  //开启异步注解功能
public class JeecgApplication {

    public static void main(String[] args) {
        SpringApplication.run(JeecgApplication.class, args);
    }
}
