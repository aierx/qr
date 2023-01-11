package icu.aierx.boot.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leiwenyong
 * @since 2023-01-10
 */
public class ConditionAQS {
	public static void main(String[] args) {
		long time = 10000_000L;
		
		ReentrantLock lock = new ReentrantLock();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.lock();
					System.out.println("1 lock");
					Thread.sleep(time);
					
					lock.unlock();
					System.out.println("1 unlock");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}).start();
		
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.lock();
					System.out.println("2 lock");
					Thread.sleep(time);
					
					lock.unlock();
					System.out.println("2 unlock");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}).start();
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.lock();
					System.out.println("3 lock");
					Thread.sleep(time);
					
					lock.unlock();
					System.out.println("3 unlock");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}).start();
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.lock();
					System.out.println("4 lock");
					Thread.sleep(time);
					lock.unlock();
					System.out.println("5 unlock");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}).start();
		
		
		
		
		
	}
}
