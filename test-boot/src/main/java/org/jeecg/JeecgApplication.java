package org.jeecg;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-03
 * @Description:
 */
@Slf4j
@SpringBootApplication
@MapperScan("org.jeecg.modules.ccKefu.mapper")
public class JeecgApplication {

    public static void main(String[] args) {
        SpringApplication.run(JeecgApplication.class, args);
    }
}
