package icu.aierx.boot.beanFactory.annonation;

import java.lang.annotation.*;

/**
 * @author leiwenyong
 * @since 2023-01-06
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface Inject {
}
