package icu.aierx.springframework.aop.support;

import icu.aierx.springframework.aop.aspectj.MethodMatcher;
import icu.aierx.springframework.aop.support.TargetSource;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public class AdvisedSupport {

    // 原始对象的实例，类的class和接口
    private TargetSource targetSource;

    // 方法拦截器
    private MethodInterceptor methodInterceptor;

    // 方法匹配器
    private MethodMatcher methodMatcher;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}
