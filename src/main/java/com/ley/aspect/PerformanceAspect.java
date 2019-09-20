package com.ley.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;
import java.time.LocalDateTime;

/**
 * log time cost.
 */
@Order(1)
@Aspect
@Component
public class PerformanceAspect {
    ThreadLocal<LocalDateTime> dtThreadLocal = new ThreadLocal<>();

    @Pointcut("@annotation(com.ley.annotation.MyPerformance)")
    public void myPointCut() {

    }

    @Before("myPointCut()")
    public void before() {
        dtThreadLocal.set(LocalDateTime.now());
    }

    @After("myPointCut()")
    public void after() {
        long seconds = ChronoUnit.MILLIS.between(dtThreadLocal.get(), LocalDateTime.now());
        System.out.println("time cost is:" + seconds + " million seconds.");
    }
}
