package icu.aierx.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        log.info("leiwenyong_into");
        log.debug("leiwenyong_debug");
        log.trace("leiwenyong_trace");
        log.error("leiwenyong_error");
        log.warn("leiwenyong_warn");
        Lei lei = new Lei();
        int add = lei.add(1, 2);
        System.out.println(add);
    }
}
