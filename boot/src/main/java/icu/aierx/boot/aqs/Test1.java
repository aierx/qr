package icu.aierx.boot.aqs;

import lombok.SneakyThrows;

import javax.xml.stream.events.StartDocument;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author leiwenyong
 * @since 2023-01-10
 */
public class Test1 {
	
	@SneakyThrows
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		
		ReentrantReadWriteLock lock1 = new ReentrantReadWriteLock();
		ReentrantReadWriteLock.ReadLock readLock = lock1.readLock();
		ReentrantReadWriteLock.WriteLock writeLock = lock1.writeLock();
		new Thread(new Runnable() {
			@SneakyThrows
			@Override
			public void run() {
				readLock.lock();
				System.out.println("read1");
				Thread.sleep(1000);
//				readLock.unlock();
				
			}
		}).start();
		new Thread(new Runnable() {
			@SneakyThrows
			@Override
			public void run() {
				readLock.tryLock();
				System.out.println("read2");
				Thread.sleep(1000);
//				readLock.unlock();
				
			}
		}).start();
		
		new Thread(new Runnable() {
			@SneakyThrows
			@Override
			public void run() {
				readLock.tryLock();
				System.out.println("read3");
				Thread.sleep(1000);
//				readLock.unlock();
			
			}
		}).start();
		Thread.sleep(2000);
		
	}
}
