package icu.aierx.boot.markword;


import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.CountDownLatch;

/**
 * @author leiwenyong
 * @since 2023-01-10
 * <p>
 * <p>
 * -XX:-UseCompressedOops 压缩指针
 * -XX:+UseBiasedLocking             偏向锁延迟
 * -XX:BiasedLockingStartupDelay=0   偏向锁延迟
 * 001 无锁
 * 101 偏向锁
 * 000	轻量级锁
 * 010 重量级锁
 * 011 GC标记信息
 */
public class Test1 {
	static CountDownLatch countDownLatch = new CountDownLatch(1000000000);
	
	public static void main(String[] args) throws Exception {
		final A a = new A();
		a.hashCode();
		synchronized (a){
		
		System.out.println(ClassLayout.parseInstance(a).toPrintable());
		}
	}
	
}
