package com.aierx.boot;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author leiwenyong
 * @since 2022-08-26
 */
@Aspect
@Component
@Slf4j
@Order(2)
public class A2 {
	@Around(value = "com.aierx.boot.A2.pointCut()")
	public Object app(ProceedingJoinPoint joinPoint) throws Throwable {
		return joinPoint.proceed();
	}
	
	@Pointcut(value = "@annotation(A2A)")
	public void pointCut(){
	
	}
}
