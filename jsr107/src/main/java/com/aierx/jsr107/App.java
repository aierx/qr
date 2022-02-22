package com.aierx.jsr107;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.aierx.jsr107")
@EnableCaching
@EnableTransactionManagement
@ImportResource("classpath:/bean.xml")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
