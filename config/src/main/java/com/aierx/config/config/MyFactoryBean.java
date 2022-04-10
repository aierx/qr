package com.aierx.config.config;

import com.aierx.config.entity.Properties;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author leiwenyong
 * @since 2022/4/10
 */
@Component
public class MyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new Properties(10,"asdadas","asdadas");
    }

    @Override
    public Class<?> getObjectType() {
        return Properties.class;
    }
}
