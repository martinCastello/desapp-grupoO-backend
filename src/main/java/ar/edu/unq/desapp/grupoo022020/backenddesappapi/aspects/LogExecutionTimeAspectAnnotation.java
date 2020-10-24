package ar.edu.unq.desapp.grupoo022020.backenddesappapi.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionTimeAspectAnnotation {

	private static Logger logger = LoggerFactory.getLogger(LogExecutionTimeAspectAnnotation.class);

	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTimeAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
		final long start = System.currentTimeMillis();
		final Object proceed = joinPoint.proceed();
		final long executionTime = System.currentTimeMillis() - start;
		logger.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
		return proceed;
	}


}
