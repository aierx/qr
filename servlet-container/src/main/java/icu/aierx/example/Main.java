package icu.aierx.example;

import icu.aierx.example.servlet.DefaultHttpServlet;
import icu.aierx.example.servlet.IndexHttpServlet;
import icu.aierx.example.servlet.LoginHttpServlet;
import icu.aierx.example.servlet.StaticHttpServlet;
import icu.aierx.server.HttpServer;
import icu.aierx.server.container.HttpContainer;
import icu.aierx.server.service.HttpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author leiwenyong
 * @since 2022/4/23
 */
public class Main {

    private static final Logger log = LoggerFactory.getLogger(DefaultHttpServlet.class);

    public static void main(String[] args) {
        try {
            HttpServer server = new HttpServer();
            HttpService service = server.getService();
            register(service);
            service.startup();
        } catch (Exception e) {
            log.error("", e);
            System.exit(1);
        }
    }

    public static void register(HttpService service) {
        HttpContainer container = service.getContainer();
        container.registerDefaultServlet("/servlet/default", DefaultHttpServlet.class);
        container.registerServlet("/servlet/index.html", IndexHttpServlet.class);
        container.registerServlet("/servlet/login", LoginHttpServlet.class);
        container.registerServlet("/servlet/static/*", StaticHttpServlet.class);
    }
}
