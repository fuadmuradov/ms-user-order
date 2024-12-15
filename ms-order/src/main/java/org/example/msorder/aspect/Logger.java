package org.example.msorder.aspect;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Slf4j
@Component
public class Logger {
    @SneakyThrows
    @Around("@annotation(org.example.msorder.annotation.Loggable)")
    public Object setLog(ProceedingJoinPoint joinPoint){
    log.info("method started");
    var response = joinPoint.proceed();
    log.info("method finished");
    return response;
    }

    @SneakyThrows
    @Around("@annotation(org.example.msorder.annotation.ElapsedTimeLogger)")
    public Object elapsedTime(ProceedingJoinPoint joinPoint){
        var startTime = System.nanoTime();
        var response = joinPoint.proceed();
        var elapsedTime = System.nanoTime() - startTime;
        log.info("Elapsed time: {} ns", elapsedTime);
        return response;
    }
}

