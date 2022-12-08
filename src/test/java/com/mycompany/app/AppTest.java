package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testEmptyString() {
        Calculator calc = new Calculator();

        String s = "";
        assertEquals(0, calc.evaluateString(s));
    }

    @Test
    public void testStringWithOneNumber() {
        Calculator calc = new Calculator();

        String s = "1";
        assertEquals(1, calc.evaluateString(s));
    }
}
