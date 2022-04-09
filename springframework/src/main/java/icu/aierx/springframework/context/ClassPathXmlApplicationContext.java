package icu.aierx.springframework.context;

import icu.aierx.springframework.beans.BeanDefinition;
import icu.aierx.springframework.beans.factory.AbstractBeanFactory;
import icu.aierx.springframework.beans.factory.AutowireCapableBeanFactory;
import icu.aierx.springframework.beans.io.ResourceLoader;
import icu.aierx.springframework.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext{

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception{
        this(configLocation,new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory)throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }


    @Override
    protected void localBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);

        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }

    }
}
