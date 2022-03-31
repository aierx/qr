package icu.aierx.mongo.controller;

import icu.aierx.mongo.UserServiceAware;
import icu.aierx.mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexCOntroller implements UserServiceAware {
    @Autowired
    UserService userService;

    @Autowired
    Environment environment;

    @Autowired
    ApplicationContext applicationContext;


    @GetMapping("/hello")
    public String getHello(){
        return "hello";
    }

    UserService userService111;

    @Override
    public void setUserService(UserService var1) {
        this.userService111 = var1;
    }
}
