package icu.aierx.boot.beanFactory;

import icu.aierx.boot.beanFactory.annonation.Aspect;
import icu.aierx.boot.beanFactory.annonation.Bean;
import icu.aierx.boot.beanFactory.annonation.Inject;
import icu.aierx.boot.beanFactory.proxy.ProxyHandler;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author leiwenyong
 * @since 2023-01-06
 */
public class Factory {
	private Map<String, Object> oneGradeCache = new HashMap<>();
	private Map<String, Object> twoGradeCache = new HashMap<>();
	private Map<String, Object> threeGradeCache = new HashMap<>();
	
	List<String> beanFile = new ArrayList<>();
	
	Map<String, Class> beanDefinition = new HashMap<>();
	List<Class> beanClass = new ArrayList<>();
	
	List<String> alreadyInstantBean = new ArrayList<>();
	
	public void init(Class cls) throws ClassNotFoundException {
		String path = cls.getResource("").getPath();
		File dir = new File(path);
		addFile(beanFile, dir);
		for (String file : beanFile) {
			Class<?> clz = Class.forName(file, true, cls.getClassLoader());
			if (hasAnnotationClass(clz, Bean.class)) {
				
				beanDefinition.put(getBeanName(clz), clz);
			}
		}
		beanDefinition.forEach((s, aClass) -> {
			if (!alreadyInstantBean.contains(s)) {
				createBean(aClass);
			}
		});
	}
	
	private Object createBean(Class aClass) {
		try {
			Object instant = aClass.newInstance();
			Object proxy = null;
			String name = getBeanName(aClass);
			// 是否需要增强
			if (hasAnnotationClass(aClass, Aspect.class)){
				Class[] interfaces = aClass.getInterfaces();
				proxy = Proxy.newProxyInstance(aClass.getClassLoader(), interfaces, new ProxyHandler(instant));
			}
			
			threeGradeCache.put(name, proxy==null?instant:proxy);
			// 依赖注入
			for (Field field : aClass.getDeclaredFields()) {
				if (hasAnnotationObject(field, Inject.class)) {
					String beanName = getBeanName(field.getType());
					Object bean = getBean(beanName);
					field.setAccessible(true);
					field.set(instant, bean);
				}
			}
			
			// 加入一级缓存
			oneGradeCache.put(name, instant);
			threeGradeCache.remove(name);
			return instant;
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Object getBean(Class type){
		for (String s : oneGradeCache.keySet()) {
			if (oneGradeCache.get(s).getClass().isAssignableFrom(type)){
				return oneGradeCache.get(s);
			}
		}
		for (String s : threeGradeCache.keySet()) {
			if (threeGradeCache.get(s).getClass().isAssignableFrom(type)){
				return threeGradeCache.get(s);
			}
		}
		return createBean(type);
	}
	
	public Object getBean(String beanName) {
		// 查看在不在一级缓存
		if (oneGradeCache != null && oneGradeCache.get(beanName) != null) {
			return oneGradeCache.get(beanName);
		}
		if (oneGradeCache != null && threeGradeCache.get(beanName) != null) {
			return threeGradeCache.get(beanName);
		}
		return createBean(beanDefinition.get(beanName));
	}
	
	private String getBeanName(Class<?> aClass) {
		final String regex = "([a-zA-z\\d]*)$";
		Pattern compile = Pattern.compile(regex);
		Matcher matcher = compile.matcher(aClass.getName());
		if (matcher.find()) {
			return matcher.group(0).toLowerCase(Locale.ROOT);
		}
		return null;
	}
	
	private boolean hasAnnotationObject(Field field, Class type) {
		return field.getAnnotation(type) != null;
	}
	
	public boolean hasAnnotationClass(Class<?> object, Class type) {
		return object.getAnnotation(type) != null;
	}
	
	
	private static void addFile(List<String> beanFile, File file) {
		if (file.listFiles() != null && file.listFiles().length == 0) return;
		for (File listFile : file.listFiles()) {
			if (listFile.isDirectory())
				addFile(beanFile, listFile);
			else if (listFile.getName().endsWith(".class")) {
				final String regex = "C:\\\\Users\\\\aleiwe\\\\Desktop\\\\qr\\\\boot\\\\target\\\\classes\\\\(.*)" +
						".class";
				final Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(listFile.getPath());
				if (matcher.find()) {
					beanFile.add(matcher.group(1).replace("\\", "."));
				}
			}
		}
	}
}
