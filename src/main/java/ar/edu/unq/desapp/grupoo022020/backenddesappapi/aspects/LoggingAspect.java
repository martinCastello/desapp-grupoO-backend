package ar.edu.unq.desapp.grupoo022020.backenddesappapi.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class LoggingAspect {

    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class.getName());

    @Pointcut("within(ar.edu.unq.desapp.grupoo022020.backenddesappapi..*) && @annotation(ar.edu.unq.desapp.grupoo022020.backenddesappapi.aspects.LogExecutionTime)")
    public void loggableMethods() {
    }

    @Before("loggableMethods()")
    public void logMethod(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info("Executing method: " + methodName);
    }

}
