package com.aierx.atx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;

@Slf4j
@SpringBootApplication
public class AtxApp {
    public static void main(String[] args) {
        SpringApplication.run(AtxApp.class, args);
    }
}
