package icu.aierx.boot.beanFactory.annonation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author leiwenyong
 * @since 2023-01-06
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Scan {
	public String value();
}
