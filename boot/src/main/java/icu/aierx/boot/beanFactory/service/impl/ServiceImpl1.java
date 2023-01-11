package icu.aierx.boot.beanFactory.service.impl;

import icu.aierx.boot.beanFactory.annonation.Aspect;
import icu.aierx.boot.beanFactory.annonation.Bean;
import icu.aierx.boot.beanFactory.annonation.Inject;
import icu.aierx.boot.beanFactory.service.Service1;

/**
 * @author leiwenyong
 * @since 2023-01-06
 */
@Bean
@Aspect
public class ServiceImpl1 implements Service1 {
	@Inject
	ServiceImpl2 service2;
	
	@Inject
	ServiceImpl1 service1;
	
	@Override
	public void show(){
		System.out.println("===> service1 show");
	}
}
