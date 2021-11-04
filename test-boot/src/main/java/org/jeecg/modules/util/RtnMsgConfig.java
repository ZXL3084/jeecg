package org.jeecg.modules.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* @author suntongxin
* Create on 2017年12月12日下午1:55:27
* All right reserved
*/
//4、注入拦截response的bean对象
@Configuration
public class RtnMsgConfig{

@Bean
public ResponseBodyWrapFactoryBean getResponseBodyWrap(){

return new ResponseBodyWrapFactoryBean();

}


}
