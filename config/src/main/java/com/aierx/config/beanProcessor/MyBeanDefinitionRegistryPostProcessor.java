package com.aierx.config.beanProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author leiwenyong
 * @since 2022/4/10
 */
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, InitializingBean, ApplicationContextAware, BeanNameAware {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("aaaaaaaaaaaa");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("aaaaaaaaaaaaaaaaaaaaa");

    }

    @Override
    public void setBeanName(String name) {
        System.out.println("aaaaaaaaaa");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("aaaaaaaaaaaaaaaaaa");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("aaaaaaaaaaaaaaaaaa");
    }
}
