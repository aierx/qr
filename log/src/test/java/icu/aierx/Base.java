package icu.aierx;

import org.apache.logging.slf4j.Log4jLogger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.LoggerFactory;

/**
 * @author leiwenyong
 * @since 2022-07-23
 */
@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.management.*", "javax.net.ssl.*", "javax.crypto.*", "javax.security.*", "javax.script.*"})
@PrepareForTest({LoggerFactory.class})
public class Base {
    public static void sleep() throws InterruptedException {
        int i = 10;
//        while (i>0){
//            Thread.sleep(100);
//            i--;
//            System.out.println(i);
//        }
    }

    @BeforeClass
    public static void test1(){
        Log4jLogger mock = Mockito.mock(Log4jLogger.class);
        PowerMockito.mockStatic(LoggerFactory.class);
        PowerMockito.when(LoggerFactory.getLogger(Mockito.any(Class.class))).thenReturn(mock);
    }

    @Test
    public void test(){
        System.out.println("hellada");
    }
}
