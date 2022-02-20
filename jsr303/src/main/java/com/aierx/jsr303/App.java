package com.aierx.jsr303;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.aierx.jsr303.dao"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
