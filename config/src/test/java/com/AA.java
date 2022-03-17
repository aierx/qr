package com;

import lombok.SneakyThrows;
import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AA {

    @Test
    public void test1() throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        File file = new File("C:/app/");
        URI uri = file.toURI();
        URL url = uri.toURL();
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});
        System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");

        Class<?> aClass1 = Class.forName("com.mysql.jdbc.Driver");

        Class<?> aClass = urlClassLoader.loadClass("Lei");
        Object o = aClass.newInstance();
//        Thread.currentThread().setContextClassLoader(ClassLoader);
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader parent = contextClassLoader.getParent();
        ClassLoader parent1 = parent.getParent();
        System.out.println("aaaaaaaaaaaaaaaaaa");

    }

    @Test
    public void test2(){
        ReentrantLock lock = new ReentrantLock();


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 20, TimeUnit.MINUTES, new LinkedBlockingDeque<>(10));
        threadPoolExecutor.execute(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true){
                    Thread.sleep(1000);
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                }
            }
        });
        threadPoolExecutor.submit(new Runnable() {
            @Override
            @SneakyThrows
            public void run() {
                while (true){
                    Thread.sleep(1000);
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                }
            }
        });


    }
}
