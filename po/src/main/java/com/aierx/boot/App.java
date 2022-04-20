package com.aierx.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
@ImportResource("classpath:/rs.service.xml")
@EnableTransactionManagement
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan( basePackages = {"com.aierx.boot.dao"})
public class App {


    public static void main(String[] args) throws SQLException, InterruptedException {
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
        DataSource bean = run.getBean(DataSource.class);
    }
}
