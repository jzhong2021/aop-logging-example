package com.mirkocaserta.example.logging.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

@Aspect
@Component
public class LoggingAspect { // NOTE: customize this class maybe?

    @Around("@annotation(com.mirkocaserta.example.domain.DebugXXX)")        //JZ: implementation
    public Object logYYY(ProceedingJoinPoint pjp) throws Throwable {
        var targetClass = pjp.getSignature().getDeclaringType();
        var log = LoggerFactory.getLogger(targetClass);
        var args = Arrays.stream(pjp.getArgs()).map(Object::toString).collect(joining(","));
        var methodName = pjp.getSignature().getName();

        System.out.println("JZ: log.isDebugEnabled()="+log.isDebugEnabled());
        //if (log.isDebugEnabled()) {
            log.debug("{}({}): invoked", methodName, args);
            log.info("{}({}): invoked", methodName, args);
        //}

        var result = pjp.proceed();

        //if (log.isDebugEnabled()) {
            log.debug("{}({}): returning; result={}", methodName, args, result);
            log.info("{}({}): returning; result={}", methodName, args, result);
        //}

        return result;
    }

}
