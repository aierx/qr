package com.aierx.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author leiwenyong
 * @since 2022/4/7
 */
public class JdkAop {


    public static void main(String[] args) {

        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        final TestImpl test = new TestImpl();
        Test hello = (Test) Proxy.newProxyInstance(JdkAop.class.getClassLoader(), new Class[]{Test.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("hello");
                return  method.invoke(test,args);
            }
        });
        hello.say();
    }
}
