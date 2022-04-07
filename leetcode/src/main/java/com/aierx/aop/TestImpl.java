package com.aierx.aop;

/**
 * @author leiwenyong
 * @since 2022/4/7
 */
public class TestImpl implements Test{
    @Override
    public void say() {
        System.out.println("Hello world");
    }
}
