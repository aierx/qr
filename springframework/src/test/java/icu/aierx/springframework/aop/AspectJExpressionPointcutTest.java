package icu.aierx.springframework.aop;

import icu.aierx.springframework.aop.aspectj.AspectJExpressionPointcut;
import icu.aierx.springframework.service.impl.HelloWordService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @title : AspectJExpressionPointcutTest
 * @author : shiziqiu
 * @date : 2018年3月2日 下午1:56:04
 * @Fun :
 */
public class AspectJExpressionPointcutTest {

    @Test
    public void testClassFilter() throws Exception {
        String expression = "execution(java.util.Map icu.**.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloWordService.class);
        System.out.println(matches);
        Assert.assertTrue(matches);
    }

    @Test
    public void testMethodInterceptor() throws Exception {
        String expression = "execution(void *(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(HelloWordService.class.getDeclaredMethod("helloWord"),HelloWordService.class);
       System.out.println(matches);
        Assert.assertTrue(matches);
    }
}
