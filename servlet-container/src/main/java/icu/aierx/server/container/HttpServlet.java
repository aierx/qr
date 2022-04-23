package icu.aierx.server.container;

import icu.aierx.server.connector.HttpServletRequest;
import icu.aierx.server.connector.HttpServletResponse;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author leiwenyong
 * @since 2022/4/23
 */
public class HttpServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        doGet((HttpServletRequest) servletRequest,(HttpServletResponse) servletResponse);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{

    }
}
