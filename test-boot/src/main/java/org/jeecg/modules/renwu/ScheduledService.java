package org.jeecg.modules.renwu;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-05
 * @Description:
 */
//https://blog.csdn.net/lcgskycby/article/details/112724461   @Scheduled 详解
//https://cron.qqe2.com/   cron自动生成
@Service
@PropertySource(value = "classpath:application.properties")
public class ScheduledService {

    @Resource
    JavaMailSender javaMailSender;

    //在一个特定的时间执行这个方法
    //秒 分 时 日 月 周几
    /**
     *  0 46 14 * * ?
     *  每天的16点04分00秒执行
     *  0 3/ * * * ?
     *  每三分钟执行一次
     */
    @Scheduled(cron = "0 46 14 * * ?")
    public void hello(){
        System.out.println("EDG，牛皮！！！！");
    }

    @Scheduled(cron = "${test_cron}")
    public void hello2(){
        System.out.println("EDG，牛皮！！！！");
    }

    @Scheduled(cron = "${chuan_cron}")
    public void hello3(){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setSubject("你好,刘川!");
        mailMessage.setText("EDG总冠军!!!!");
        mailMessage.setTo("1107787991@qq.com");
        mailMessage.setFrom("3084348388@qq.com");
        javaMailSender.send(mailMessage);
        System.out.println("发送完了-----");
    }


//    void contextLoads2() throws MessagingException {
//
//        //一个复杂的邮件
//        MimeMessage  mailMessage= javaMailSender.createMimeMessage();
//
//        //组装
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mailMessage,true);
//
//        mimeMessageHelper.setSubject("你好spring------plus");
//        mimeMessageHelper.setText("<p style='color:red'>qwerty</p>",true);
//
//        //附件
//        mimeMessageHelper.addAttachment("1.jpg",new File("C:\\Users\\70723\\Desktop\\1.jpg"));
//
//        mimeMessageHelper.setTo("3084348388@qq.com");
//        mimeMessageHelper.setFrom("3084348388@qq.com");
//        javaMailSender.send(mailMessage);
//    }
//
//    public void sendmail(Boolean html,String subject,String text) throws MessagingException {
//        //一个复杂的邮件
//        MimeMessage mailMessage= javaMailSender.createMimeMessage();
//
//        //组装
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mailMessage,html);
//
//        mimeMessageHelper.setSubject(subject);
//        mimeMessageHelper.setText(text,true);
//
//        //附件
//        mimeMessageHelper.addAttachment("1.jpg",new File("C:\\Users\\70723\\Desktop\\1.jpg"));
//
//        mimeMessageHelper.setTo("3084348388@qq.com");
//        mimeMessageHelper.setFrom("3084348388@qq.com");
//        javaMailSender.send(mailMessage);
//    }


    //阿里云发送短信服务 代码由阿里云短信服务平台生成，拿来用即可 配置相关个人信息
    @Test
    void smsMessage(){  //AccessKey ID 账号 AccessKey secret密码
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G16F251gw8zRaePUPQo", "你自己的密码");
        IAcsClient client = new DefaultAcsClient(profile);
        //阿里云原有的配置信息我们不需要改动
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");

        //自定义短信信息
        request.putQueryParameter("PhoneNumbers", "156161123XX"); //发送给哪个手机号
        request.putQueryParameter("SignName", "清峰小栈");  //自己配置的短信签名
        request.putQueryParameter("TemplateCode", "SMS_205128031"); //自己配置的模板 模版CODE

        //构建一个短信验证码
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",8456);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(map));   //转换成json字符串
        try {
            CommonResponse response = client.getCommonResponse(request); //发送至客户端
            System.out.println(response.getData());
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }


}
