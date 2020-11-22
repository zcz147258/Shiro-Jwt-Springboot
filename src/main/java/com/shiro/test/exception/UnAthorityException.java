package com.shiro.test.exception;

import com.shiro.test.utils.R;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Data
@AllArgsConstructor  //生成有参数构造方法
@NoArgsConstructor   //生成无参数构造
public class UnAthorityException extends RuntimeException  {
    private Integer code;//状态码
    private String msg;//异常信息
}
