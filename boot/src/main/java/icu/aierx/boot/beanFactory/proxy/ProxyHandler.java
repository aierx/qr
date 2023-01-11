package icu.aierx.boot.beanFactory.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author leiwenyong
 * @since 2023-01-06
 */
public class ProxyHandler<T> implements InvocationHandler {
	
	private T target;
	
	public ProxyHandler(T target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("=======>");
		Object invoke = method.invoke(target, args);
		System.out.println("=======>");
		return invoke;
	}
}
