package icu.aierx.boot.thread;

/**
 * @author leiwenyong
 * @since 2023-01-09
 */
public class Test1 {
	
	public static void main(String[] args) throws InterruptedException {
		final boolean flag = true;
		
		for (int i = 0; i < 10; i++) {
			final int b = i;
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					while (b == 2 && flag) {
						System.out.println("[start][thread name]: " + Thread.currentThread().getName());
						Thread.yield();
						System.out.println("[end][thread name]: " + Thread.currentThread().getName());
					}
					System.out.println("[thread name]: " + Thread.currentThread().getName());
				}
			});
			thread.start();
			if (i == 2) {
				thread.wait();
			}
		}
		
		
		System.out.println("aaaaaaaaaaaaaaaaaaa<=");
		System.out.println("aaaaaaaaaaaaaaaaaaa=>");
	}
	
	
}
