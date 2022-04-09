package icu.aierx.springframework.beans.factory;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public interface BeanFactory {

    Object getBean(String beanName) throws Exception;
}
