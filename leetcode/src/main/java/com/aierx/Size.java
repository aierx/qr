package com.aierx;


import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class Size {

    static int count = 0;
    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        threadLocal();
    }

    public static void threadLocal(){
        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("leiwenyong");
        new Thread(()->{
            String t2 = local.get();
            System.out.println(t2);
            local.set("nihao");
            System.out.println(local.get());
            local.remove();
        }).start();
        System.out.println(local.get());
    }


    public static void count(){
        ThreadLocal<String> local = new ThreadLocal<>();
        Runnable runnable = ()->{
            int n = 10000;
            local.set(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName()+":"+ local.get());
            reentrantLock.lock();
            while (n>0){
                count++;
                n--;
            }
            reentrantLock.unlock();
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        Thread t5 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }


    public void thread1(){
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(runnable, "this" + i);
            thread.start();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
    }
}
