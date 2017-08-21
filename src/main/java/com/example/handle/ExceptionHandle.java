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
//好像是个什么controller作用未知
public class ExceptionHandle {

    //好像是出异常了会走到这个方法里,具体不知
    @ExceptionHandler
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
}
