package com.aierx.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

import java.sql.SQLException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootApplication
@ImportResource("classpath:/rs.service.xml")
@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootConfiguration
@MapperScan( basePackages = {"com.aierx.boot.dao"})
public class App {
    private int count = 0;
    private static final int SUM = 10;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) throws SQLException, InterruptedException {
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
    }
}
