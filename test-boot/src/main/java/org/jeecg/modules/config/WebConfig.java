package org.jeecg.modules.config;

import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-26
 * @Description:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new BufferedImageHttpMessageConverter()); //图像转换

//        //1.默认在SpringBoot中所提供的转换器为jackson.首先就需要移除
//        for (int i = 0; i < converters.size(); i++) {
//            if (converters.get(i) instanceof MappingJackson2CborHttpMessageConverter){
//                converters.remove(i);
//            }
//        }
//
//        //2.项目中是一定需要一个转换器的，可以将FastJson转换器配置到容器中
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter=new FastJsonHttpMessageConverter();
//        //3.fastjson进行最终的消息的转换处理的时候是需要相关定义的配置的
//        FastJsonConfig config=new FastJsonConfig(); //fastjson配置
//        config.setSerializerFeatures(
//                SerializerFeature.WriteMapNullValue,  //允许Map的内容为空
//                SerializerFeature.WriteNullListAsEmpty, //List集合为null则为[]代替
//                SerializerFeature.WriteNullStringAsEmpty,//String字符串为null就使用空字符串代替
//                SerializerFeature.WriteDateUseDateFormat,//日期格式化输出
//                SerializerFeature.WriteNullNumberAsZero,//数字为空就0
//                SerializerFeature.DisableCircularReferenceDetect //禁用循环引用
//        );//配置相关的序列化的操作
//        fastJsonHttpMessageConverter.setFastJsonConfig(config);
//        //4.既然要输出的是json，就要配置好响应头消息
//        List<MediaType> fastJsonmediaType=new ArrayList<>();//定义响应的类型
//        fastJsonmediaType.add(MediaType.APPLICATION_JSON);//使用json类型响应
//        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastJsonmediaType);
//
//        //5.在转换器类表中加入当前配置完成的fastjson组件
//        converters.add(fastJsonHttpMessageConverter);
    }
}
