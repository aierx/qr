package com.aierx.jsr107;

import com.aierx.jsr107.dao.UserDao;
import com.aierx.jsr107.model.po.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StopWatch;

@SpringBootApplication
@MapperScan("com.aierx.jsr107")
@EnableCaching
@EnableTransactionManagement
@ImportResource("classpath:/bean.xml")
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
        UserDao bean = run.getBean(UserDao.class);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 10000; i++) {
            User userById = bean.findUserById(1);
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeSeconds());
        System.exit(1);
    }
}
