package com.aierx.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

import java.sql.SQLException;

@SpringBootApplication
@ImportResource("classpath:/rs.service.xml")
@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootConfiguration
@MapperScan( basePackages = {"com.aierx.boot.dao"})
public class App {


    public static void main(String[] args) throws SQLException, InterruptedException {
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
        System.out.println("adsada");
    }
}
