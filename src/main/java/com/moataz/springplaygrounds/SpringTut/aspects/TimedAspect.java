package com.moataz.springplaygrounds.SpringTut.aspects;

import lombok.extern.log4j.Log4j2;
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
@Log4j2
public class TimedAspect {

    @Around("@annotation(com.moataz.springplaygrounds.SpringTut.annotations.Timed)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Before");

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        log.info("Method executed in {} ms", end - start);
        return result;
    }
//    @After("@annotation(com.moataz.springplaygrounds.annotations.Timed)")
//    public void logMethodName(JoinPoint joinPoint){
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//
//
//
//        // Log the method execution
//        System.out.println("Method " + methodName + " executed with arguments: " + Arrays.toString(args));
//    }


}
