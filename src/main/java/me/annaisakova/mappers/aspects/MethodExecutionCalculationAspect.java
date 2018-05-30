package me.annaisakova.mappers.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodExecutionCalculationAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(me.annaisakova.mappers.aspects.TrackTime)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();

        Object result = joinPoint.proceed();

        logger.info("Created object: {}", result);

        long timeTaken = System.nanoTime() - startTime;
        logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
        return result;
    }
}
