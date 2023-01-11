package icu.aierx.boot.thread;

/**
 * @author leiwenyong
 * @since 2023-01-09
 */
public class Test2 extends Thread{
	
	private final Object self;
	private final Object last;
	
	public Test2(String name,Object self,Object last){
		super(name);
		this.self = self;
		this.last = last;
	}
	
	
	
	@Override
	public void run() {
		for (int i = 0; i <10 ; i++) {
			synchronized (last){
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (self){
					if(super.getName().equals("A")){
						System.out.println("第"+(i+1)+"次运行");
					}
					System.out.println(super.getName());
					self.notifyAll();
					try {
						Thread.sleep(1000);
						System.out.println("[wait]: "+super.getName());
					}catch (InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		
		Test2 a1 = new Test2("A", a, b);
		Test2 a2 = new Test2("B", b, c);
		Test2 a3 = new Test2("C", c, a);
		
		a1.start();
		a2.start();
		a3.start();
	}
}
