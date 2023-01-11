package icu.aierx.boot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author leiwenyong
 * @since 2023-01-06
 */
@Aspect
@Component
public class AopAspect {
	
	@After("execution(* icu.aierx.boot.test.A.*())||execution(* icu.aierx.boot.test.B.*())")
	public void after(JoinPoint jp){
		System.out.println("aaaaaaaaaaaaaaa");
	}
}
