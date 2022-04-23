package com.aierx.boot;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

/**
 * @author leiwenyong
 * @since 2022/4/23
 */
public abstract class BaseTest {
    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }
}
