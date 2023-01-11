package icu.aierx.boot.beanFactory.service.impl;

import icu.aierx.boot.beanFactory.annonation.Bean;
import icu.aierx.boot.beanFactory.annonation.Inject;
import icu.aierx.boot.beanFactory.service.Service2;

/**
 * @author leiwenyong
 * @since 2023-01-06
 */
@Bean
public class ServiceImpl2 implements Service2 {
	@Inject
	ServiceImpl1 service1;
	@Override
	public void show(){
		System.out.println("===> service1 show");
	}
}
