package icu.aierx.po;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.sql.SQLException;

@SpringBootApplication
@ImportResource("classpath:/rs.service.xml")
@MapperScan( basePackages = {"icu.aierx.po.dao"})
public class POApp {
    
    public static void main(String[] args) throws SQLException, InterruptedException {
        ConfigurableApplicationContext run = SpringApplication.run(POApp.class, args);
    
        System.out.println("");
    }
}
