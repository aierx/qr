package com.aierx.config;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AA {

    public static int clientTotal = 5000;
    public static volatile AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        //使用CountDownLatch来等待计算线程执行完
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        //开启clientTotal个线程进行累加操作
        for(int i=0;i<clientTotal;i++){
            new Thread(() -> {
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count.incrementAndGet();//自加操作
                countDownLatch.countDown();
            }).start();
        }
        //等待计算线程执行完
        countDownLatch.await();
        System.out.println(count);
    }

}

class Singleton {
    private static Singleton instance = null;

    private Singleton() {
    }

    public void show() {
        System.out.println("初始化");
    }

    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}

class ThreadDemo implements Runnable {
    private boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        flag = true;
        System.out.println("flag=" + isFlag());
    }

    public boolean isFlag() {
        return flag;
    }
}
