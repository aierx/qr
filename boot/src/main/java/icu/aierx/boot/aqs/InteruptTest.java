package icu.aierx.boot.aqs;

/**
 * @author leiwenyong
 * @since 2023-01-10
 */
public class InteruptTest {
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			int i = 0;
			
			@Override
			public void run() {
				while (true) {
					i++;
					if (Thread.currentThread().isInterrupted()){
						System.out.println("aaaaaaaaaaaa");
					}
				}
				
			}
		});
		
		System.out.println("+++++++++++++++++");
		thread.start();
		thread.interrupt();
		
		
		
	}
}
