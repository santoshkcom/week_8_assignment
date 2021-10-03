package com.greatlearning.security.config;

import com.greatlearning.security.repository.AuditRepository;
import com.greatlearning.security.service.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Slf4j
@Aspect
@Configuration
public class AspectConfig {
    @Autowired
    AuditRepository auditRepository;

    @Autowired
    RestaurantService employeeService;

    @Around("execution(public * com.greatlearning.security.serviceImpl.*.*(..) )")
    public void logBeforeAndAfterAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info(proceedingJoinPoint.getSignature().getName() + " Started");
        proceedingJoinPoint.proceed();
        log.info(proceedingJoinPoint.getSignature().getName() + " Ended");
    }

}
