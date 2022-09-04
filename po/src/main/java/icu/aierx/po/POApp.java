package icu.aierx.po;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:/rs.service.xml")
@MapperScan( basePackages = {"icu.aierx.po.dao"})
public class POApp {
    
    public static void main(String[] args) {
        SpringApplication.run(POApp.class, args);
    }
}
