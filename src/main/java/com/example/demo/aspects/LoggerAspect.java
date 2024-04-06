package com.example.demo.aspects;

import com.example.demo.entity.ActivityLog;
import com.example.demo.exceptions.AopIsAwesomeHeaderException;
import com.example.demo.repository.ActivityLogRepo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggerAspect {
    private final ActivityLogRepo activityLogRepo;
    private final HttpServletRequest request;

    @Around("@annotation(com.example.demo.annotations.ExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        // save data to ActivityLog table
        activityLogRepo.save(new ActivityLog(LocalDate.now(), joinPoint.getSignature().getName(), end - start));
        return result;
    }

    @Before("execution(* com.example.demo.service.*.*(..))")
    public void checkApiWithHeader() throws Throwable {
        if (request.getMethod().equals("POST") && request.getHeader("AOP-IS-AWESOME") == null) {
            throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header is needed");
        }
    }
}
