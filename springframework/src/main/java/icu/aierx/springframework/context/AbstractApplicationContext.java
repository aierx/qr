package icu.aierx.springframework.context;

import icu.aierx.springframework.beans.BeanPostProcessor;
import icu.aierx.springframework.beans.factory.AbstractBeanFactory;

import java.util.List;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public abstract class AbstractApplicationContext implements ApplicationContext{

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception{
        // 加载bean
        localBeanDefinitions(beanFactory);
        // 加载可用的BeanPostProcessor
        registerBeanPostProcessor(beanFactory);
        onRefresh();
    }

    private void registerBeanPostProcessor(AbstractBeanFactory beanFactory)throws Exception {
        List<Object> beanPostProcessors = beanFactory.getBeanForType(BeanPostProcessor.class);
        for (Object beanPostProcessor : beanPostProcessors) {
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }

    private void onRefresh()throws Exception {
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void localBeanDefinitions(AbstractBeanFactory beanFactory)throws Exception;

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
