package icu.aierx.boot.markword;

public class A {
    int i;
    public synchronized void parse() {
        Test1.countDownLatch.countDown();
        i++;
    }
}