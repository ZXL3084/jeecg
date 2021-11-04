package org.jeecg.modules.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
* @author suntongxin
* Create on 2017年12月12日下午1:55:12
* All right reserved
*/
//3、定义未处理异常统一拦截
@ControllerAdvice
public class CommExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public RtnMsg handle(Exception e) {
        RtnMsg msg = new RtnMsg(RtnCode.STATUS_SYSERROR, "系统异常，异常原因：" + e.getMessage());
        return msg;
    }
}
