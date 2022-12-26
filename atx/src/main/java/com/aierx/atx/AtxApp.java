package com.aierx.atx;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@EnableDubbo
public class AtxApp {
    public static void main(String[] args) {
        SpringApplication.run(AtxApp.class, args);
    }
}
