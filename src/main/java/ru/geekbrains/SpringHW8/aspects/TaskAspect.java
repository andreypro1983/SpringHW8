package ru.geekbrains.SpringHW8.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class TaskAspect {
    //Вывод информации о методах и их аргументах аннотированных @TrackUserAction
    @Around("@annotation(ru.geekbrains.SpringHW8.aspects.TrackUserAction)")
    public Object TrackUserActionByAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {

        Object proceed = joinPoint.proceed();
        String methodeName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        System.out.println("В " + joinPoint.getThis() + " вызван метод " + methodeName
                + " с параметрами "
                + Arrays.asList(arguments));
        return proceed;
    }
}
