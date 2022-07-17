package com.aierx.atx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EnableRedisRepositories
public class AtxApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(AtxApp.class, args);
    }
}
