package com.aierx.boot;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author leiwenyong
 * @since 2022-08-26
 */
@Target({TYPE, FIELD, METHOD})
@Retention(RUNTIME)
public @interface A2A {
}
