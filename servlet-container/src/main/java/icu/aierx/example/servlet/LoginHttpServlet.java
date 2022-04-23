package icu.aierx.example.servlet;

import icu.aierx.server.Utils;
import icu.aierx.server.connector.HttpServletRequest;
import icu.aierx.server.connector.HttpServletResponse;
import icu.aierx.server.container.HttpServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import java.io.IOException;

public class LoginHttpServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(LoginHttpServlet.class);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        log.info(LoginHttpServlet.class.getSimpleName() + " doGet | username: " + username + ", password: " + password);
        Utils.copyInText(LoginHttpServlet.class.getResourceAsStream("/html/success.html"), response.getOutputStream(), true, false);
    }

}