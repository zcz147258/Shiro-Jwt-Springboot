package com.shiro.test.httplog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author alvins
 * @Description 请求接口日志拦截器
 * @date 2020/6/14 13:41
 * @since 1.0
 */
@Aspect
@Component
public class LogRequestRecordAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(LogRequestRecordAspect.class);

    /**
     * 定义切点
     */
    @Pointcut("execution(* com.atguigu.aclservice.controller..*.*(..))")
    public void webRequestLogs() {
    }

    /**
     * 请求日志打印
     *
     * @param point
     */
    @Before("webRequestLogs()")
    public void doBefore(JoinPoint point) {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        String beanName = point.getSignature().getDeclaringTypeName();
        String methodName = point.getSignature().getName();
        String uri = request.getRequestURI();
        Object[] paramsArray = point.getArgs();
        LOGGER.info("uri={} | beanName={} | methodName={} | params={}", uri, beanName, methodName, paramsArray);
    }
}
