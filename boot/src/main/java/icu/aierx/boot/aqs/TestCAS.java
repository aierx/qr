package icu.aierx.boot.aqs;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;

/**
 * @author leiwenyong
 * @since 2023-01-10
 */
public class TestCAS {
	
	private static Unsafe unsafe;
	volatile int value = 0;
	private static long offset;
	
	static {
		try {
			//通过反射获取rt.jar下的Unsafe类
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			unsafe = (Unsafe) field.get(null);
			
			Class clazz = Target.class;
			Field field1 = TestCAS.class.getDeclaredField("value");
			offset = unsafe.objectFieldOffset(field1);
		} catch (Exception e) {
			System.out.println("Get Unsafe instance occur error" + e);
		}
	}
	
	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
		long z = 1000_000_00L;
		TestCAS test2 = new TestCAS();
		
		
//		CountDownLatch count = new CountDownLatch(5);
//		long l1 = System.currentTimeMillis();
//		for (int i = 0; i < 5; i++) {
//			new Thread(() -> {
//				for (int j = 0; j < z; j++) {
//					test2.addCAS();
//				}
//				count.countDown();
//			}).start();
//		}
//		count.await();
//		long e1 = System.currentTimeMillis();
//		System.out.println(String.format("add CAS %sms", e1 - l1));
		
		
//		CountDownLatch count1 = new CountDownLatch(5);
//		long l = System.currentTimeMillis();
//		for (int i = 0; i < 5; i++) {
//			new Thread(() -> {
//				for (int j = 0; j < z; j++) {
//					test2.add();
//				}
//				count1.countDown();
//			}).start();
//		}
//		count1.await();
//		long e = System.currentTimeMillis();
//		System.out.println(String.format("add %sms", e - l));

		
		long l3 = System.currentTimeMillis();
		for (int i = 0; i < 5*z; i++) {
			test2.value++;
		}
		long e3 = System.currentTimeMillis();
		System.out.println(String.format("directly add %sms", e3 - l3));
		
		System.out.println(test2.value);
	}
	
	
	public void add() {
		synchronized (TestCAS.class) {
			value++;
		}
	}
	
	public void addCAS() {
		unsafe.getAndAddInt(this, offset, 1);
	}
	
}
