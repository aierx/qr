package icu.aierx.boot.markword;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author leiwenyong
 * @since 2023-01-10
 */
public class IntegerAdd {
	private volatile int value = 0;
	
	private static Unsafe unsafe;
	
	private static long offset;
	
	static {
		try {
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			unsafe = (Unsafe) field.get(null);
			offset = unsafe.objectFieldOffset(IntegerAdd.class.getDeclaredField("value"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public  int getAndAddInt(Object obj,long offset,int var4){
		return unsafe.getAndAddInt(obj,offset,var4);
	}
	
}
