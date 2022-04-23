package icu.aierx.server.connector;

import icu.aierx.server.Utils;
import icu.aierx.server.container.HttpContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author leiwenyong
 * @since 2022/4/23
 */
public class HttpConnector {

    private static final Logger log = LoggerFactory.getLogger(HttpConnector.class);

    private String hostname;

    private int port;

    private HttpContainer container;

    public HttpConnector(HttpContainer container) {
        this.container = container;
        this.hostname = "localhost";
        this.port = 8080;
    }

    public void startup() throws Exception {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName(hostname));
            log.info("Server is starting, listener port {}", port);

            Socket socket = null;
            while (true) {
                try {
                    socket = serverSocket.accept();
                    process(socket);
                } catch (Exception e) {
                    log.error("", e);
                } finally {
                    Utils.quietlyClosed(socket);
                }
            }
        } finally {
            Utils.quietlyClosed(serverSocket);
        }
    }

    private void process(Socket socket) throws Exception {
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        try {
            log.debug("receive a request from " + socket.getRemoteSocketAddress().toString());

            //
            request = new HttpServletRequest(socket.getInputStream());
            response = new HttpServletResponse(socket.getOutputStream());
            container.execute(request, response);
            response.flush();
            socket.shutdownOutput();
            log.debug("responded to " + socket.getRemoteSocketAddress().toString());
        } finally {
            Utils.quietlyClosed(response, request, socket);
        }
    }


    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
