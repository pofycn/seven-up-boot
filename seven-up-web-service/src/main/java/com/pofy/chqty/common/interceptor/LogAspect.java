package com.pofy.chqty.common.interceptor;

import com.pofy.chqty.common.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * function - AOP统一处理日志
 *
 * @author POFY
 * @version 1.0
 * @date 2018-06-03
 **/
@Component
@Aspect
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    private static final String START = "Start";

    private static final String END = "End";

    @Pointcut("execution(* com.pofy.chqty.controller..*(..))")
    private void controllerLog() {
    }

    @Pointcut("execution(* com.pofy.chqty.service..*(..))")
    private void serviceLog() {
    }

    @Before(value = "controllerLog()||serviceLog()")
    public void before(JoinPoint joinPoint) throws ClassNotFoundException {
        processLog(joinPoint, START);
    }

    @After(value = "controllerLog()||serviceLog()")
    public void after(JoinPoint joinPoint) throws ClassNotFoundException {
        processLog(joinPoint, END);
    }

    private void processLog(JoinPoint joinPoint, String message) throws ClassNotFoundException {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        Class<?> targetClass = Class.forName(className);
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase(methodName)) {
                Class<?>[] clazzs = method.getParameterTypes();
                if (clazzs.length == args.length) {
                    Log logAnnotation = method.getAnnotation(Log.class);
                    if (logAnnotation != null) {
                        String logMsg = logAnnotation.msg();
                        logger.info("{}:{}---{}", className, logMsg, message);
                        //TODO:数据库操作记录
                    }
                }
            }
        }
    }
}
