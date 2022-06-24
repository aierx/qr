package com.aierx.atx;

import com.aierx.atx.model.po.UserPO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class AtxApp {

    public static void main(String[] args) {
        // 拉萨大阿达萨达
        ConfigurableApplicationContext run = SpringApplication.run(AtxApp.class, args);
        MongoTemplate mongoTemplate = run.getBean(MongoTemplate.class);
        mongoTemplate.insert(new UserPO("aaa","aaa"));
        System.exit(0);
    }
}
