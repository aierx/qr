package icu.aierx.springframework.beans.xml;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
