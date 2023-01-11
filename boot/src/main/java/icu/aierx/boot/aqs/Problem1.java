package icu.aierx.boot.aqs;

import lombok.SneakyThrows;
import sun.misc.Unsafe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leiwenyong
 * @since 2023-01-10
 */
public class Problem1 {
	/**
	 * A 打印05次A
	 * B 打印10次B
	 * C 打印15次C
	 * ...
	 *
	 * @param args
	 */
	
	static volatile Integer num = 1;
	
	
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Condition c1 = lock.newCondition();
		Condition c2 = lock.newCondition();
		Condition c3 = lock.newCondition();
		
		
		new Thread(new Runnable() {
			@SneakyThrows
			@Override
			public void run() {
				for (int j = 0; j < 10; j++) {
					
					lock.tryLock(10, TimeUnit.SECONDS);
					while (num != 1) {
						c1.await();
					}
					for (int i = 0; i < 1; i++) {
						System.out.println("[" + Thread.currentThread().getName() + "]: A");
					}
					num = 2;
					c2.signal();
					lock.unlock();
				}
				
			}
			
		}, "A").start();
		
		new Thread(new Runnable() {
			@SneakyThrows
			@Override
			public void run() {
				for (int j = 0; j < 10; j++) {
					
					lock.lock();
					while (num != 2) {
						c2.await();
					}
					
					for (int i = 0; i < 2; i++) {
						System.out.println("[" + Thread.currentThread().getName() + "]: B");
					}
					num = 3;
					c3.signalAll();
					
				}
				
				lock.unlock();
			}
		}, "B").start();
		new Thread(new Runnable() {
			@SneakyThrows
			@Override
			public void run() {
				for (int j = 0; j < 10; j++) {
					
					lock.lock();
					while (num != 3) {
						c3.await();
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("[" + Thread.currentThread().getName() + "]: C");
					}
					num = 1;
					c1.signal();
				}
				
			}
		}, "C").start();
	}
}
