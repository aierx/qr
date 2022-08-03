package icu.aierx;

import icu.aierx.log.Lei;
import org.junit.Test;
import org.mockito.InjectMocks;

/**
 * @author leiwenyong
 * @since 2022-07-23
 */
public class lei2 extends Base {

    @InjectMocks
    Lei lei;

    @Test
    public void testAdd() throws InterruptedException {
        sleep();
        lei.add(1,2);
    }

}
