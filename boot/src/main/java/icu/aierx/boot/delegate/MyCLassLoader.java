package icu.aierx.boot.delegate;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author leiwenyong
 * @since 2023-01-09
 */
public class MyCLassLoader extends ClassLoader {
	
	@Override
	protected Class<?> findClass(String name) {
		File file = new File("C:\\Users\\aleiwe\\Desktop\\qr\\atx\\target\\classes", name.replace(".", "\\").concat(".class"));
		try (FileInputStream fis = new FileInputStream(file); ByteArrayOutputStream bos = new ByteArrayOutputStream()){
			byte[] buffer = new byte[1024];
			int b = 0;
			while ((b = fis.read(buffer))!=-1){
				bos.write(buffer,0,b);
			}
			byte[] bytes = bos.toByteArray();
			return defineClass(name,bytes,0,bytes.length);
		}catch (Exception e){
		
		}
		return null;
	}
}
