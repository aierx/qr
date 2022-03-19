package icu.aierx.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author leiwenyong
 * @since 2022/3/17
 */
@SpringBootApplication
//@MapperScan("icu.aierx.elasticsearch.dao")
@EnableJpaRepositories(basePackages = "icu.aierx.elasticsearch.repository")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
