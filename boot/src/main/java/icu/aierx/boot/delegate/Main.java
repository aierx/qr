package icu.aierx.boot.delegate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author leiwenyong
 * @since 2023-01-09
 */
public class Main {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
		ArrayList<String> strings = new ArrayList<>();
		strings.add("aaaaaaaaaa");
		MyCLassLoader loader = new MyCLassLoader();
//		Class<?> aClass = loader.findClass("com.aierx.atx.model.U");
		Class<?> aClass1 = Class.forName("com.aierx.atx.model.U", true, new MyCLassLoader());
		Object o = aClass1.newInstance();
		Method show = aClass1.getMethod("show", new Class[]{});
		show.invoke(o);
	}
	
}
