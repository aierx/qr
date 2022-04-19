package com.aierx;

import icu.aierx.mybatis.App;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * @author leiwenyong
 * @since 2022/4/12
 */
public class MyAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("this is an agent.");
        inst.addTransformer(new MyTransformer());
    }

    public static void agentmain (String agentArgs, Instrumentation inst) throws UnmodifiableClassException {
        inst.addTransformer(new MyTransformer(), true);
        inst.retransformClasses(App.class); //指明哪些类需要重新加载
    }
}

