package com.aierx.config.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aop {

    @Pointcut("execution(public * com.aierx.config.beanProcessor.*.*(..))")
    public void log(){
        System.out.println("====>切面");
    }

    @After(value = "log()")
    public void aa(){
        System.out.println("aaaaa");
    }


}
