package icu.aierx.boot.test;

/**
 * @author leiwenyong
 * @since 2023-01-07
 */
//@Component
//@Scope("prototype")
public class A implements Ai {
//	@Autowired
//	@Lazy
	Bi b;
	
	public void setB(B b) {
		this.b = b;
	}

//	@Override
//	public void show() {
//		System.out.println("aaaaaaaaaaaa");
//
//	}
}
