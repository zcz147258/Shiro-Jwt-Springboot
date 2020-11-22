package com.shiro.test.exception;

import com.shiro.test.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//捕捉异常
    @ResponseBody//返回数据
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("执行了全局异常处理");
    }

    //特定异常
    @ExceptionHandler(AuthorizationException.class)
    @ResponseBody //为了返回数据
    public R error(AuthorizationException e) {
        log.error(e.getMessage());
        return R.error().code(401).message("没有权限");
    }
}
