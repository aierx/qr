package icu.aierx.springframework.aop;

import icu.aierx.springframework.aop.support.AdvisedSupport;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public abstract class AbstractAopProxy implements AopProxy {


    protected AdvisedSupport advisedSupport;

    // 传入通知事件
    public AbstractAopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }
}
