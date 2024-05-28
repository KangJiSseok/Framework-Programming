package org.tukorea.free.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.tukorea.free.TraceStatus;
import org.tukorea.free.logtrace.ThreadLocalLogTrace;

@Slf4j
@Aspect
@Component
public class LogTraceAspect {

    private final ThreadLocalLogTrace logTrace;

    public LogTraceAspect(ThreadLocalLogTrace logTrace) {
        this.logTrace = logTrace;
    }

    @Around("execution(* org.tukorea.free..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        TraceStatus status = null;
        try {
            String message = joinPoint.getSignature().toShortString();
            status = logTrace.begin(message);

            //로직 호출
            Object result = joinPoint.proceed();

            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}