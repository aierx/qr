package icu.aierx.po;

/**
 * @author leiwenyong
 * @since 2022-08-30
 */
public enum AtxUser {
	/**
	 * 姓名
	 */
	lei("lei")
	;
	
	private String name;
	
	AtxUser(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
