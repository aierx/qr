package icu.aierx.example.servlet;

import icu.aierx.server.connector.HttpServletRequest;
import icu.aierx.server.connector.HttpServletResponse;
import icu.aierx.server.container.HttpServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;

public class IndexHttpServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(IndexHttpServlet.class);

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        log.info(IndexHttpServlet.class.getSimpleName() + " init");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info(IndexHttpServlet.class.getSimpleName() + " doGet");
        response.getWriter().flush();
//        Utils.copyInText(IndexHttpServlet.class.getResourceAsStream("/html/index.html"), response.getOutputStream(), true, false);
    }
}