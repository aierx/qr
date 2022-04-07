package com.aierx.aop;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author leiwenyong
 * @since 2022/4/7
 */
public class CglibAop {
    public static void main(String[] args) {
        TestImpl test = new TestImpl();
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"C:\\Users\\aleiwe\\Desktop\\qr\\leetcode\\target");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TestImpl.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("111111111");
            Object a = methodProxy.invoke(test, objects);
            System.out.println("1111111111111");
            return a;
        });
        TestImpl o = (TestImpl) enhancer.create();

        o.say();
    }
}
