package org.booking.ticket.utils.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* org.booking.ticket.controller.*.*(..))")
    public void allMethods() {
        // Pointcut to match all methods within your.package
    }

    @Before("allMethods()")
    public void logBeforeMethodCall(JoinPoint joinPoint) {
        logger.info("Method execution started: {}", joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "allMethods()", returning = "result")
    public void logAfterMethodCall(Object result) {
        logger.info("After method call with result: {}", result);
    }
}
