package com.example.spring_aop_demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	// this will run before any method inside service package
    @Before("execution(* com.example.spring_aop_demo.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(">>> AOP Before: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.spring_aop_demo.service.*.*(..))", returning = "result")
    public void logAfter(JoinPoint jp, Object result) {
        System.out.println("Executed: " + jp.getSignature() + " | Returned: " + result);
    }

    @Around("execution(* com.example.spring_aop_demo.service.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Execution of " + pjp.getSignature() + " took " + elapsed + " ms");
        return obj;
    }

    @AfterThrowing(pointcut = "execution(* com.example.spring_aop_demo.service.*.*(..))", throwing = "ex")
    public void logException(JoinPoint jp, Exception ex) {
        System.out.println("Exception in " + jp.getSignature() + " -> " + ex.getMessage());
    }


}
