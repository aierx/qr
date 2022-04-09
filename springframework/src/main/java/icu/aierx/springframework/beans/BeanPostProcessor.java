package icu.aierx.springframework.beans;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public interface BeanPostProcessor {
    // 前置处理器
    Object postProcessorBeforeInitialization(Object bean,String beanName) throws Exception;

    // 后置处理器
    Object postProcessorAfterInitialization(Object bean,String beanName) throws Exception;

}
