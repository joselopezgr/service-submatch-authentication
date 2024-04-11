package com.jlg.submatch.service.user.exception;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MongoDBExceptionHandlerAspect {

    @AfterThrowing(pointcut = "@annotation(error)", throwing = "ex")
    public void handleException(RuntimeException ex, MongoDBExceptionHandler error) {
        throw new UserException(error.message());
    }
}
