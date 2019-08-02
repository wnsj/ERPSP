package com.jiubo.erp.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @desc:aop测试类
 * @date: 2019-07-31 10:39
 * @author: dx
 * @version: 1.0
 */
//① 在类上使用 @Component 注解 把切面类加入到IOC容器中
//② 在类上使用 @Aspect 注解 使之成为切面类
//@Aspect
//@Component
//@Configuration
public class WebLogAcpect {

    private Logger logger = LoggerFactory.getLogger(WebLogAcpect.class);

    private String AOP_POINTCUT_EXPRESSION = "execution(public * com.jiubo.erp.wzbg.controller.*.*(..))";

    /**
     * 定义切入点，切入点为com.example.aop下的所有函数
     */
    @Pointcut("execution(public * com.jiubo.erp.wzbg.controller.*.*(..))")
    public void webLog() {
    }

    /**
     * 前置通知：在连接点之前执行的通知
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }

}
