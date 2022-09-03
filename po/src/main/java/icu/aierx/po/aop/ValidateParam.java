package icu.aierx.po.aop;

import org.aspectj.lang.annotation.Before;

/**
 * @author leiwenyong
 * @since 2022-08-06
 */
//@Aspect
//@Service
public class ValidateParam {
	
	
	@Before(value = "@annotation(com.aierx.boot.aop.Valid)")
	public void before(){
		System.out.println("asdadsada");
	}
	
}
