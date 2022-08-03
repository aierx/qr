package icu.aierx.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author leiwenyong
 * @since 2022-07-23
 */
public class Lei {
    private static final Logger log = LoggerFactory.getLogger(Lei.class);

    public int add(int i,int b ){
        log.trace("a++++b");
        log.error("a+b");
        return i+b;
    }
    public int sub(int i,int b ){
        log.error("a-----b");
        log.trace("a-b");
        return i-b;
    }
}
