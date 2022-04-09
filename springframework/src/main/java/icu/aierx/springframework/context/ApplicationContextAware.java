package icu.aierx.springframework.context;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public interface ApplicationContextAware {

    void setApplicationContext(ApplicationContext applicationContext) throws Exception;

}
