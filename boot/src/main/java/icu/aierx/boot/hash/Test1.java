package icu.aierx.boot.hash;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author leiwenyong
 * @since 2023-01-09
 */
public class Test1 {
	
	public static void main(String[] args) {
		ConcurrentHashMap<Integer, Integer> hashMap = new ConcurrentHashMap<>();
		
		hashMap.put(0,1);
		hashMap.put(12,0);
		hashMap.put(11,0);
		
	}
}
