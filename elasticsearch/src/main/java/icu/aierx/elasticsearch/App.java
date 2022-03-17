package icu.aierx.elasticsearch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author leiwenyong
 * @since 2022/3/17
 */
@SpringBootApplication
@MapperScan("icu.aierx.elasticsearch.dao")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
