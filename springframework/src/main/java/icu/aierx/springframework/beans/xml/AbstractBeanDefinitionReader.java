package icu.aierx.springframework.beans.xml;

import icu.aierx.springframework.beans.BeanDefinition;
import icu.aierx.springframework.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader( ResourceLoader resourceLoader) {
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
