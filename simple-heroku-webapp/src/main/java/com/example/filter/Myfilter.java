package com.example.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author leiwenyong
 * @since 2022-05-15
 */
public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init my filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("my filter begin");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("my filter end");
    }

    @Override
    public void destroy() {
        System.out.println("destroy my filter");
    }
}
