package com.aierx.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.aierx.config")
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
        String hello = run.getEnvironment().getProperty("lei");
        System.out.println(hello);
        System.exit(0);
    }
}
