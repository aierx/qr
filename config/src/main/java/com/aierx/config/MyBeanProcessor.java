package com.aierx.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanProcessor implements BeanPostProcessor {

    int i = 0;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        i++;
        System.out.printf("[%4s] ==> "+bean.getClass().getSimpleName()+"\n",i);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
