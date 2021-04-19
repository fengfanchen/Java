package cn.it1995.controller;

import cn.it1995.Response.CommonResp;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/***
 * 统一异常处理、数据预处理
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public CommonResp validExceptionHandler(BindException e){

        CommonResp commonResp = new CommonResp();
        commonResp.setSuccess(false);
        e.printStackTrace();
        commonResp.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return commonResp;
    }
}
