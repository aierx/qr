package icu.aierx.boot.aqs;

import com.sun.org.apache.bcel.internal.generic.LoadClass;
import icu.aierx.boot.XmlApp;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leiwenyong
 * @since 2023-01-10
 */
public class ReentranLockTest {
	static int i = 1;
	
	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lock = new ReentrantLock(true);
		long z = 10_000L;

//		CountDownLatch latch = new CountDownLatch(5);
//		long e = System.currentTimeMillis();
//		for (int j = 0; j < 5; j++) {
//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//
//					lock.lock();
//					for (int k = 0; k < 1000000; k++) {
//						i++;
//					}
//					lock.unlock();
//
//					try {
//						latch.countDown();
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//
//				}
//			}).start();
//		}
//
//		latch.await();
//		long s = System.currentTimeMillis();
//		System.out.println(String.format("%sms",s-e));
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					
					lock.tryLock(10, TimeUnit.SECONDS);
					System.out.println("lock1");
					Thread.sleep(z);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println("1 unlock");
					lock.unlock();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.lock();
					System.out.println("lock2");
					Thread.sleep(z);
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					System.out.println("2 unlock");
					lock.unlock();
				}
			}
		}).start();
//
//
	
		
	}
}
