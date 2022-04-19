package com.aierx;

import java.lang.instrument.Instrumentation;

/**
 * @author leiwenyong
 * @since 2022/4/13
 */
public class MybatisLogAsm {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("this is an agent.");
        inst.addTransformer(new MybatisLogTransformer());
    }

}
