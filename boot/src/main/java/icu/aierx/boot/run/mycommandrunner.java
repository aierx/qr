package icu.aierx.boot.run;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.*;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.beans.PropertyDescriptor;

/**
 * @author leiwenyong
 * @since 2023-01-06
 */
@Service
@Slf4j
public class mycommandrunner implements
		BeanNameAware,
		BeanClassLoaderAware,
		BeanFactoryAware,
		EnvironmentAware,
		ApplicationContextAware,
		ApplicationEventPublisherAware,
		BeanDefinitionRegistryPostProcessor,
		BeanFactoryPostProcessor,				// bean工厂后置处理器
		BeanPostProcessor,						// bean后置处理器
		InstantiationAwareBeanPostProcessor,	// 实例化处理器
		InitializingBean,						// 初始化处理器
		DestructionAwareBeanPostProcessor,
		DisposableBean , ApplicationRunner {							// 销毁
	int count = 0;
	int afterPropertiesSet = 0;
	int postProcessBeanFactory = 0;
	int postProcessBeforeInstantiation = 0;
	int postProcessAfterInstantiation = 0;
	int postProcessProperties = 0;
	int postProcessPropertyValues = 0;
	int postProcessBeforeInitialization = 0;
	int postProcessAfterInitialization = 0;
	int destroy = 0;
	int postProcessBeanDefinitionRegistry = 0;
	
	public mycommandrunner() {
		log.warn("construct");
	}
	@PostConstruct
	public void postConstruct(){
		log.warn("postConstruct");
	}
	
	@Override
	public void setBeanName(String name) {
		log.warn("setBeanName");
	}
	
	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		log.warn("setBeanClassLoader");
	}
	
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		log.warn("setBeanFactory");
	}
	
	@Override
	public void setEnvironment(Environment environment) {
		log.warn("setEnvironment");
	}
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		log.warn("setApplicationEventPublisher");
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		log.warn("setApplicationContext");
	}
	
	
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		if (postProcessBeanFactory != 1) {
			log.warn(String.valueOf(++count));
			postProcessBeanFactory++;
			log.warn("postProcessBeanFactory");
		}
	}
	
	
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		if (postProcessBeforeInstantiation != 1) {
			log.warn(String.valueOf(++count));
			postProcessBeforeInstantiation++;
			log.warn("postProcessBeforeInstantiation");
		}
		return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
	}
	
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		if (postProcessAfterInstantiation != 1) {
			log.warn(String.valueOf(++count));
			postProcessAfterInstantiation++;
			log.warn("postProcessAfterInstantiation");
		}
		return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
	}
	
	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		if (postProcessProperties != 1) {
			log.warn(String.valueOf(++count));
			postProcessProperties++;
			log.warn("postProcessProperties");
		}
		return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
	}
	
	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
													String beanName) throws BeansException {
		if (postProcessPropertyValues != 1) {
			log.warn(String.valueOf(++count));
			postProcessPropertyValues++;
			log.warn("postProcessPropertyValues");
		}
		return InstantiationAwareBeanPostProcessor.super.postProcessPropertyValues(pvs, pds, bean, beanName);
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (postProcessBeforeInitialization != 1) {
			log.warn(String.valueOf(++count));
			postProcessBeforeInitialization++;
			log.warn("postProcessBeforeInitialization");
		}
		
		return bean;
	}
	
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (postProcessAfterInitialization != 1) {
			log.warn(String.valueOf(++count));
			postProcessAfterInitialization++;
			log.warn("postProcessAfterInitialization");
		}
		return bean;
	}
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if (afterPropertiesSet != 1) {
			log.warn(String.valueOf(++count));
			afterPropertiesSet++;
			log.warn("afterPropertiesSet");
		}
		
	}
	
	
	@Override
	public void destroy() throws Exception {
		if (destroy != 1) {
			log.warn(String.valueOf(++count));
			destroy++;
			log.warn("destroy");
		}
		
	}
	int postProcessBeforeDestruction = 0;
	@Override
	public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
		if (postProcessBeforeDestruction != 1) {
			log.warn(String.valueOf(++count));
			postProcessBeforeDestruction++;
			log.warn("postProcessBeforeDestruction");
		}
	}
	
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		if (postProcessBeanDefinitionRegistry != 1) {
			log.warn(String.valueOf(++count));
			postProcessBeanDefinitionRegistry++;
			log.warn("postProcessBeanDefinitionRegistry");
		}
	}
	
	public void show(){
		System.out.println("===========>");
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("aaaaaaaaaaaaaaaaa");
		
	}
}
