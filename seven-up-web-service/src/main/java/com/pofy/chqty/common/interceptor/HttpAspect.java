package com.pofy.chqty.common.interceptor;

import com.pofy.chqty.entity.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * function - HttpAspect
 *
 * @author POFY
 * @version 1.0
 * @date 2018-05-22
 **/
@Aspect
@Component
public class HttpAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.pofy.chqty.controller..*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        LOGGER.info("URL:{}", request.getRequestURL());
        //method
        LOGGER.info("method:{}", request.getMethod());
        //ip
        LOGGER.info("IP Address:{}", request.getRemoteAddr());
        //class_method
        LOGGER.info("class method:{}", joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
        //args[]
        LOGGER.info("args:{}", joinPoint.getArgs());
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Result result = null;
        try {

        } catch (Exception e) {
            //return exceptionHandle.exceptionGet(e);
        }
        if (result == null) {
            return proceedingJoinPoint.proceed();
        } else {
            //return result;
        }
        return result;
    }

    @AfterReturning(pointcut = "log()", returning = "object")
    public void doAfterReturing(Object object) {
        LOGGER.info("response={}", object.toString());
    }
}

