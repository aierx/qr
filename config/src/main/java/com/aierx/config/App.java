package com.aierx.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
        String hello = run.getEnvironment().getProperty("leiwenyong");
        System.out.println(hello);
        System.exit(0);
    }
}
