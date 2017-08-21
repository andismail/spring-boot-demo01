package com.example.handle;

import com.example.domain.Result;
import com.example.exception.GirlException;
import com.example.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常统一处理
 * Created by Jthan on 17/8/20.
 */
@ControllerAdvice
/*
控制器通知是任意带有@ControllerAdvice注解的类,这个类会包含一个或多个如下类型的方法:
@ExceptionHandler注解标的方法;
@InitBinder注解标的方法;
@ModelAttribute注解标的方法.

在带有@ControllerAdvice注解的类中,以上所述的这些方法会运用到整个应用程序所有控制器
中带有@RequestMapping注解的方法上.
 */
public class ExceptionHandle {

    @ExceptionHandler//异常处理方法
    @ResponseBody
    public Result handle(Exception e) {
        //出现的异常是GirlException时才处理
        if (e instanceof GirlException) {
            GirlException ge = (GirlException) e;
            //取出异常中有用的信息
            //此出把异常信息格式化成controller接口格式一样的返回形式
            return ResultUtil.error(ge.getCode(), ge.getMessage());
        }
        return ResultUtil.error(-1, "unknow error");
    }
    /*
    如果任意的控制器方法抛出Exception,不管这个方法位于哪个控制器中,都会调用这个方法来处理异常.
    我们可以像编写@RequestMapping注解的方法那样来编写@ExceptionHandler注解的方法.
     */
}
