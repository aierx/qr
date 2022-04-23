package icu.aierx.example.servlet;

import icu.aierx.server.Utils;
import icu.aierx.server.connector.HttpServletRequest;
import icu.aierx.server.connector.HttpServletResponse;
import icu.aierx.server.container.HttpServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author leiwenyong
 * @since 2022/4/23
 */
public class DefaultHttpServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DefaultHttpServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info(DefaultHttpServlet.class.getSimpleName() + " doGet");
        Utils.copyInText(DefaultHttpServlet.class.getResourceAsStream("/html/404.html"), response.getOutputStream(), true, false);
    }
}
