package com.aierx.jsr303.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = VersionCheckValidator.class)
public @interface VersionCheck {
    public String tableName() default "";

    String message() default "该版本已存在，请刷新后保存";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
