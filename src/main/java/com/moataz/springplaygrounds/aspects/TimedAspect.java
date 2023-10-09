package com.moataz.springplaygrounds.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class TimedAspect {
    private static final Logger logger = LoggerFactory.getLogger(TimedAspect.class);

    @Around("@annotation(com.moataz.springplaygrounds.annotations.Timed)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        logger.info("Method {} executed in {} ms", joinPoint.getSignature(), end - start);
        return result;
    }

    @After("@annotation(com.moataz.springplaygrounds.annotations.Timed)")
    public void logMethodName(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        // Log the method execution
        System.out.println("Method " + methodName + " executed with arguments: " + Arrays.toString(args));
    }


}
