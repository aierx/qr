package icu.aierx.springframework.aop.support;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public class TargetSource {
    // 类对象
    private Class<?> targetClass;
    // 类接口
    private Class<?> interfaces;
    // 类实例
    private Object target;

    public TargetSource(Class<?> targetClass, Class<?> interfaces, Object target) {
        this.targetClass = targetClass;
        this.interfaces = interfaces;
        this.target = target;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Class<?> getInterfaces() {
        return interfaces;
    }

    public Object getTarget() {
        return target;
    }
}
