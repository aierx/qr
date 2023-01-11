package icu.aierx.boot.lock;

import lombok.SneakyThrows;

/**
 * @author leiwenyong
 * @since 2023-01-09
 */
public class Test1 {
	@SneakyThrows
	public static void main(String[] args) {
		ThreadLocal<String> local1 = new ThreadLocal<>();
		ThreadLocal<String> local2 = new ThreadLocal<>();
		ThreadLocal<String> local3 = new ThreadLocal<>();
		ThreadLocal<String> local4 = new ThreadLocal<>();
		ThreadLocal<String> local5 = new ThreadLocal<>();
		ThreadLocal<String> local6 = new ThreadLocal<>();
		ThreadLocal<String> local7 = new ThreadLocal<>();
		ThreadLocal<String> local8 = new ThreadLocal<>();
		ThreadLocal<String> local9 = new ThreadLocal<>();
		ThreadLocal<String> local10 = new ThreadLocal<>();
		ThreadLocal<String> local11 = new ThreadLocal<>();
		ThreadLocal<String> local12 = new ThreadLocal<>();
		ThreadLocal<String> local13 = new ThreadLocal<>();
		ThreadLocal<String> local14 = new ThreadLocal<>();
		for (int i = 0; i < 50 ; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("===> " + Thread.currentThread().getName());
					local1.set("1000");
					local2.set("1001");
					local3.set("1002");
					local3.get();
					local3.remove();
					local4.set("1003");
					local5.set("1004");
					local6.set("1005");
					local7.set("1006");
					local8.set("1007");
					local9.set("1008");
					local10.set("1009");
					local11.set("1011");
					local12.set("1012");
					local13.set("1013");
					local14.set("1014");
				}
			}).start();
		}

		
	}
}
