package icu.aierx.springframework.beans.factory;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public interface BeanFactoryAware {
    void setBeanFactory(BeanFactory beanFactory)throws Exception;
}
