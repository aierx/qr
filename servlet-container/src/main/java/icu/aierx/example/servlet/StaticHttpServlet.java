package icu.aierx.example.servlet;

import icu.aierx.server.Utils;
import icu.aierx.server.connector.HttpServletRequest;
import icu.aierx.server.connector.HttpServletResponse;
import icu.aierx.server.container.HttpServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.InputStream;

public class StaticHttpServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(StaticHttpServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info(StaticHttpServlet.class.getSimpleName() + " doGet");

        String filename = request.getUri().replace("/servlet/static/", "");
        InputStream is = StaticHttpServlet.class.getResourceAsStream("/static/" + filename);
        if (is != null) {
            Utils.copyInBinary(is, response.getOutputStream(), true, false);
        }
    }

}