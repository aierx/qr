package com.aierx.boot.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    /**
     * Method under test: {@link Result#makeFail(String)}
     */
    @Test
    void testMakeFail() {
        Result actualMakeFailResult = Result.makeFail("Not all who wander are lost");
        assertEquals("Not all who wander are lost", actualMakeFailResult.getMessage());
        assertFalse(actualMakeFailResult.getFlag());
    }

    /**
     * Method under test: {@link Result#makeFail(String, Object)}
     */
    @Test
    void testMakeFail2() {
        Result actualMakeFailResult = Result.makeFail("Not all who wander are lost", "Data");
        assertEquals("Data", actualMakeFailResult.getData());
        assertEquals("Not all who wander are lost", actualMakeFailResult.getMessage());
        assertFalse(actualMakeFailResult.getFlag());
    }

    /**
     * Method under test: {@link Result#makeSuccess(String, Object)}
     */
    @Test
    void testMakeSuccess() {
        Result actualMakeSuccessResult = Result.makeSuccess("Not all who wander are lost", "Data");
        assertEquals("Data", actualMakeSuccessResult.getData());
        assertEquals("Not all who wander are lost", actualMakeSuccessResult.getMessage());
        assertTrue(actualMakeSuccessResult.getFlag());
    }

    /**
     * Method under test: {@link Result#Result(Boolean, String)}
     */
    @Test
    void testConstructor() {
        Result actualResult = new Result(true, "Not all who wander are lost");

        assertNull(actualResult.getData());
        assertEquals("Not all who wander are lost", actualResult.getMessage());
        assertTrue(actualResult.getFlag());
    }
}

