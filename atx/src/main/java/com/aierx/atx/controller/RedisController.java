package com.aierx.atx.controller;

import com.aierx.atx.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author leiwenyong
 * @since 2022-05-21
 */
@RestController
public class RedisController {



//    @Resource
//    RedisTemplate<String, String> redisTemplate;


    public void setKey(String value,Long time){
        String key = "maker:" + new SimpleDateFormat("yyyy-MM-dd");
//        Boolean hasKey = redisTemplate.hasKey(key);
//        redisTemplate.opsForList().leftPush(key,new SimpleDateFormat("HH-mm-ss").format(new Date()));
//
//        if (!hasKey){
//            redisTemplate.expire(key,1,TimeUnit.DAYS);
//        }


    }


    @GetMapping("/lei")
    public User userPO(boolean isQuery){
//        redisTemplate.opsForValue().set("wenyong2",new UserPO("leiwen","wewqe"));
//        redisTemplate.opsForValue().set("decisionMaker-1001","1");
//        redisTemplate.opsForValue().set("decisionMaker-1002","1");
//        redisTemplate.opsForValue().set("decisionMaker-1003","1");
//        redisTemplate.opsForValue().set("decisionMaker-1004","1");
//        redisTemplate.opsForValue().set("decisionMaker-1005","1");
//        redisTemplate.opsForValue().set("decisionMaker-1006","1");
//        redisTemplate.opsForValue().set("decisionMaker-1007","1");
//        redisTemplate.expire("decisionMaker-1001",10, TimeUnit.SECONDS);

        


        List<String> strings = new ArrayList<>();
        strings.add("decisionMaker-1001");
        strings.add("decisionMaker-1002");
        strings.add("decisionMaker-1003");
        strings.add("decisionMaker-1004");
        strings.add("decisionMaker-10020");
//        redisTemplate.opsForValue().increment("wenyong1",2);

//        redisTemplate.expire("leiwenyong",10000, TimeUnit.SECONDS);
        return new User("leiw");
    }


}
