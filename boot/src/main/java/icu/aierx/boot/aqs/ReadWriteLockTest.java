package icu.aierx.boot.aqs;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author leiwenyong
 * @since 2023-01-10
 */
public class ReadWriteLockTest {
	public static void main(String[] args) {
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
		ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
		writeLock.newCondition();
		
		
		long time = 5_000L;
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					writeLock.lock();
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					writeLock.unlock();
				}
				
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					writeLock.lock();
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					writeLock.unlock();
				}
			}
		}).start();
		
		
	}
}
