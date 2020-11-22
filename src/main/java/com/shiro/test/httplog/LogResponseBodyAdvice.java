package com.shiro.test.httplog;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author alvins
 * @Description Request响应日志
 * @date 2020/6/14 13:44
 * @since 1.0
 */
@ControllerAdvice
public class LogResponseBodyAdvice implements ResponseBodyAdvice {

    public static final Logger LOGGER = LoggerFactory.getLogger(LogResponseBodyAdvice.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        LOGGER.info("uri={} | responseBody={}", serverHttpRequest.getURI().getPath(), JSON.toJSONString(body));
        return body;
    }
}
