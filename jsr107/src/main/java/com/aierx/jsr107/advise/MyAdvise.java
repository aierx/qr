package com.aierx.jsr107.advise;

import org.springframework.stereotype.Service;

@Service
public class MyAdvise {
    public void before(){
        System.out.println("aspect 方法开始");
    }
}
