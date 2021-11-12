package org.jeecg.modules.handler;

import org.jeecg.modules.handler.exception.GirlException;
import org.jeecg.modules.util.Result;
import org.jeecg.modules.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//**新建一个handle包，新建ExceptionHandle.java类**

//```java
/**
 * 捕获异常的类，返回信息给浏览器，可以自定义返回的code,msg等信息
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlException) {   //判断异常是否是我们定义的异常
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        }else {
            logger.error("【系统异常】{}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
