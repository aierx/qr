package icu.aierx.springframework.beans.factory;

import icu.aierx.springframework.beans.BeanReference;
import icu.aierx.springframework.beans.BeanDefinition;
import icu.aierx.springframework.beans.PropertyValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    public void applyPropertyValues(Object bean, BeanDefinition beanDefinition)throws Exception{
        if (bean instanceof BeanFactoryAware){
            ((BeanFactoryAware)bean).setBeanFactory(this);
        }
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValueList()) {
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference){
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            try {
                Method declaredMethod = bean.getClass().getDeclaredMethod("set" + propertyValue.getName().substring(0, 1).toUpperCase()
                        + propertyValue.getName().substring(1), value.getClass());
                declaredMethod.setAccessible(true);
                // 直接调用bean的set方法进行设值
                declaredMethod.invoke(bean,value);
            }catch (Exception e){
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean,value);
            }

        }
    }
}
