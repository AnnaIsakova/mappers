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
    private static long totalTimeToDto;
    private static int numOfCallsToDto;
    private static long totalTimeFromDto;
    private static int numOfCallsFromDto;

    @Around("@annotation(me.annaisakova.mappers.aspects.TrackTimeToDto)")
    public Object aroundToDto(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();

        Object result = joinPoint.proceed();

        logger.info("Created object: {}", result);

        long timeTaken = System.nanoTime() - startTime;
        totalTimeToDto += timeTaken;
        numOfCallsToDto += 1;
        logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
        logger.info("Total: {}; NumOfCalls: {}", totalTimeToDto, numOfCallsToDto);
        logger.info("Average Time Taken by {} is {}", joinPoint, (totalTimeToDto/numOfCallsToDto));
        return result;
    }

    @Around("@annotation(me.annaisakova.mappers.aspects.TrackTimeFromDto)")
    public Object aroundFromDto(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();

        Object result = joinPoint.proceed();

        logger.info("Created object: {}", result);

        long timeTaken = System.nanoTime() - startTime;
        totalTimeFromDto += timeTaken;
        numOfCallsFromDto += 1;
        logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
        logger.info("Total: {}; NumOfCalls: {}", totalTimeFromDto, numOfCallsFromDto);
        logger.info("Average Time Taken by {} is {}", joinPoint, (totalTimeFromDto/numOfCallsFromDto));
        return result;
    }
}
