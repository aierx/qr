package icu.aierx.mongo.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class UserService implements ApplicationContextAware, EnvironmentAware {

    ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext =applicationContext;
    }

    Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
