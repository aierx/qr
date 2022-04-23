package icu.aierx.server.service;

import icu.aierx.server.connector.HttpConnector;
import icu.aierx.server.container.HttpContainer;

/**
 * @author leiwenyong
 * @since 2022/4/23
 */
public class HttpService {
    private HttpConnector connector;
    private HttpContainer container;

    public HttpService() {
        container = new HttpContainer();
        connector = new HttpConnector(container);
    }

    public void startup() throws Exception {
        connector.startup();
    }

    public HttpContainer getContainer() {
        return container;
    }

    public HttpConnector getConnector() {
        return connector;
    }
}
