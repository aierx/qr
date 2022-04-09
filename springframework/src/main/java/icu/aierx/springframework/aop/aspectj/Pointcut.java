package icu.aierx.springframework.aop.aspectj;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
