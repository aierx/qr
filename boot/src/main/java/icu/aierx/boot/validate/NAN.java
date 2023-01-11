package icu.aierx.boot.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author leiwenyong
 * @since 2022-08-05
 */
@Documented
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface NAN {
	String message() default "{javax.validation.constraints.NotBlank.message}";
	
	Class<?>[] groups() default { };
	
	
	/**
	 * Defines several {@code @NotBlank} constraints on the same element.
	 *
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
	@Retention(RUNTIME)
	@Documented
	public @interface List {
	}
}
