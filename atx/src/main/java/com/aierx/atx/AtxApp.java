package com.aierx.atx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
//@EnableRedisRepositories
@Slf4j
public class AtxApp {

  HashMap map =   new HashMap<String,Object>();
    
    public static void main(String[] args) {
//        ConfigurableApplicationContext run = SpringApplication.run(AtxApp.class, args);
//        List<Integer> strings = new ArrayList<>();
//        strings.add(4);
//        strings.add(2);
//        strings.add(3);
//        strings.add(1);
//        List<Integer> collect = strings.stream().sorted((o,p)->{
//         return    p-o;
//        }).collect(Collectors.toList());
//
//        System.out.println(strings);
    
        try {
        
        AtxApp atxApp = new AtxApp();
        atxApp.leiwe();
        }catch (Exception e){
            System.out.println("lasdadasda");
        }
    
    
    }
    
    
    public void leiwe(){
        
        
        try {
            System.out.println("asdadada");
            throw new IllegalArgumentException("asdada");
        }catch (Exception e){
            map.put("asdasda",e);
            throw  e;
        }
    }
}
