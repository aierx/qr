package com.aierx.atx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableRedisRepositories
@Slf4j
public class AtxApp {

    public static void main(String[] args) {
//        ConfigurableApplicationContext run = SpringApplication.run(AtxApp.class, args);
        log.info("leiwenyong_into");
        log.debug("leiwenyong_debug");
        log.trace("leiwenyong_trace");
        log.error("leiwenyong_error");
        log.warn("leiwenyong_warn");
    }
}
