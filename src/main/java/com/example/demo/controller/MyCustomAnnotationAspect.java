package com.example.demo.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyCustomAnnotationAspect {
    @Around("@annotation(myCustomAnnotation)") // Around advice to intercept methods annotated with @LogExecutionTime
    public Object myCustomAnnotation(ProceedingJoinPoint pjp, MyCustomAnnotation myCustomAnnotation) throws Throwable {
        System.out.println("Annotaion........");
        long startTime = System.currentTimeMillis();

        Object proceed = pjp.proceed(); // Proceed with the method execution

        long executionTime = System.currentTimeMillis() - startTime;

        System.out.println(pjp.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }
}
