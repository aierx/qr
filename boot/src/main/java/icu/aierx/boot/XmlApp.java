package icu.aierx.boot;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author leiwenyong
 * @since 2023-01-08
 */
public class XmlApp {
	public static void main(String[] args) {
		//创建父容器parentFactory
		DefaultListableBeanFactory parentFactory = new DefaultListableBeanFactory();
		//向父容器parentFactory注册一个bean[userName->"路人甲Java"]
		parentFactory.registerBeanDefinition("userName",
				BeanDefinitionBuilder.
						genericBeanDefinition(String.class).
						addConstructorArgValue("路人甲Java").
						getBeanDefinition());
		
		//创建一个子容器childFactory
		DefaultListableBeanFactory childFactory = new DefaultListableBeanFactory();
		//调用setParentBeanFactory指定父容器
		childFactory.setParentBeanFactory(parentFactory);
		//向子容器parentFactory注册一个bean[address->"上海"]
		childFactory.registerBeanDefinition("address",
				BeanDefinitionBuilder.
						genericBeanDefinition(String.class).
						addConstructorArgValue("上海").
						getBeanDefinition());
		
		System.out.println("获取bean【userName】：" + childFactory.getBean("userName"));//@1
		childFactory.getBeanNamesForType(String.class);
		BeanFactoryUtils.beanNamesForTypeIncludingAncestors(childFactory,String.class);
	}
}
