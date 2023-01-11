package icu.aierx.boot.beanFactory;

import icu.aierx.boot.beanFactory.annonation.Scan;
import icu.aierx.boot.beanFactory.service.impl.ServiceImpl1;

/**
 * @author leiwenyong
 * @since 2023-01-06
 */
@Scan("icu.aierx.boot.beanFactory")
public class App {
	public static void main(String[] args) throws ClassNotFoundException {
		Factory factory = new Factory();
		factory.init(App.class);
		ServiceImpl1 service1 = (ServiceImpl1)factory.getBean("serviceImpl1");
		service1.show();
		
//		Service1 o = (Service1)Proxy.newProxyInstance(ServiceImpl1.class.getClassLoader(),
//				new Class[]{Service1.class},
//				new ProxyHandler(new ServiceImpl1()));
//		o.show();
	}
}
