package icu.aierx.springframework.beans.factory;

import icu.aierx.springframework.beans.BeanDefinition;
import icu.aierx.springframework.beans.BeanPostProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public class AbstractBeanFactory implements BeanFactory{

    // bean工厂里维护类的字典，类名 Class对象
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    // bean 的名称集合
    private final List<String> beanDefinitionNames = new ArrayList<>();

    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String beanName) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (null==beanDefinition){
            throw new IllegalArgumentException("No bean Named "+beanName+" in beanDefinition");
        }
        Object bean = beanDefinition.getBean();
        if (null == bean){
            // 创建对象
            bean = createBean(beanDefinition);
            // 调用beanPostProcessor初始化对象
            bean = initializeBean(bean,beanName);
            // 将初始化的bean塞入beanDefinition
            beanDefinition.setBean(bean);
        }
        return bean;
    }

    /**
     * beanPostProcessor发挥作用的地方
     * @param bean
     * @param beanName
     * @return
     */
    public Object initializeBean(Object bean, String beanName) throws Exception{
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessorAfterInitialization(bean, beanName);
        }
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessorAfterInitialization(bean, beanName);
        }
        return bean;
    }

    /**
     * 创建bean
     *
     * @param beanDefinition
     * @return
     */
    public Object createBean(BeanDefinition beanDefinition) throws Exception {
        // 实例化bean对象
        Object bean = createBeanInstance(beanDefinition);
        // 将实例化后的bean塞入beanDefinition中去
        beanDefinition.setBean(bean);
        // 设置bean的属性值
        applyPropertyValues(bean,beanDefinition);
        return bean;
    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception{

    }

    public Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    public void preInstantiateSingletons() throws Exception{
        if (this.beanDefinitionNames.size()>0){
            for (String beanName : beanDefinitionNames) {
                getBean(beanName);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public List<Object> getBeanForType(Class classType)throws Exception{
        List<Object> beans = new ArrayList<>();
        for (String beanName : beanDefinitionNames) {
            if (classType.isAssignableFrom(beanDefinitionMap.get(beanName).getBeanClass())){
                beans.add(getBean(beanName));
            }
        }
        return beans;
    }

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) throws Exception {
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public void registerBeanDefinition(String beanName,BeanDefinition beanDefinition){
        beanDefinitionMap.put(beanName,beanDefinition);
        beanDefinitionNames.add(beanName);
    }

}
