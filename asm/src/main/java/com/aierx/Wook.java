package com.aierx;

/**
 * @author leiwenyong
 * @since 2022/4/16
 */
public class Wook {


    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("清理垃圾");
        }));
        int t = 1000;
        while (t-->0){
            System.out.println(t);
        }
    }
}
