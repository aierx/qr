package icu.aierx.boot.channel;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @Author: xiaoshijiu
 * @Date: 2020/2/27
 * @Description: 
 */
public class PhantomReferenceDemo {

    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
    
        // 虚引用必须要和引用队列一起使用，他的get方法永远返回null
        WeakReference<byte[]> phantomReference = new WeakReference<>(
                new byte[1024 * 1024 * 6], queue);
    
        System.out.println("======================>");
    
        System.gc();
    
        Thread.sleep(300L);
    
        System.out.println("======================>");
        
        byte[] bytes = new byte[1024 * 1024 * 6];
    }

}