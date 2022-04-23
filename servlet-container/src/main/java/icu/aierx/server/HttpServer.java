package icu.aierx.server;

import icu.aierx.server.service.HttpService;

/**
 * @author leiwenyong
 * @since 2022/4/23
 */
public class HttpServer {

    private HttpService service;

    public HttpServer() {
        service = new HttpService();
    }

    public HttpService getService() {
        return service;
    }
}
