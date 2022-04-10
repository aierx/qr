package com.aierx.config.beanProcessor;

import com.aierx.config.entity.Properties;
import com.aierx.config.entity.PropertiesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl1 implements HelloService{

    @Autowired
    PropertiesDao propertiesDao;

    @Autowired
    Properties properties;



    @Override
    public void sayHello() {
        System.out.println("你好我是HelloServiceImpl1");
    }
}