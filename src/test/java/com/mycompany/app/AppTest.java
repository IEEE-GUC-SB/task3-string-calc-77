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

    @Test
    public void testStringWithTwoNumbers() {
        Calculator calc = new Calculator();

        String s = "1,2";
        assertEquals(3, calc.evaluateString(s));
    }

    @Test
    public void testStringWithUnkownAmountOfNumbers() {
        Calculator calc = new Calculator();

        String s = "1,2,3,4";
        assertEquals(10, calc.evaluateString(s));
    }
}
