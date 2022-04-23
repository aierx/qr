package icu.aierx.server.container;

import javax.servlet.Servlet;

/**
 * @author leiwenyong
 * @since 2022/4/23
 */
public class ServletRegistrar {

    private String uri;

    private Class<? extends Servlet> clazz;

    private Servlet instance;

    public ServletRegistrar(String uri, Class<? extends Servlet> clazz){
        this.uri = uri;
        this.clazz = clazz;
    }

    public ServletRegistrar(String uri, Class<? extends Servlet> clazz, Servlet instance) {
        this.uri = uri;
        this.clazz = clazz;
        this.instance = instance;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Class<? extends Servlet> getClazz() {
        return clazz;
    }

    public void setClazz(Class<? extends Servlet> clazz) {
        this.clazz = clazz;
    }

    public Servlet getInstance() {
        return instance;
    }

    public void setInstance(Servlet instance) {
        this.instance = instance;
    }
}
