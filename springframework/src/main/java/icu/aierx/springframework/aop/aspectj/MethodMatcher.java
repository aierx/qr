package icu.aierx.springframework.aop.aspectj;

import java.lang.reflect.Method;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public interface MethodMatcher {
    boolean matches(Method method,Class targetClass);
}
