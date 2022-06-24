package com.example.heroku;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * This class launches the web application in an embedded Jetty container. This is the entry point to your application. The Java
 * command that is used for launching should fire this main method.
 */
public class Main {

    public static void main(String[] args) throws Exception{
        final Server server = new Server(8080);
        final WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setParentLoaderPriority(true);
        final String services = "src/main/webapp/";
        context.setDescriptor(services + "/WEB-INF/wab.xml");
        context.setResourceBase(services);
        server.setHandler(context);
        server.start();
        server.join();
    }
}
