package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {

    @Test
    public void testEmptyString() throws Exception {
        Calculator calc = new Calculator();

        String s = "";
        assertEquals(0, calc.evaluateString(s));
    }

    @Test
    public void testStringWithOneNumber() throws Exception {
        Calculator calc = new Calculator();

        String s = "1";
        assertEquals(1, calc.evaluateString(s));
    }

    @Test
    public void testStringWithTwoNumbers() throws Exception {
        Calculator calc = new Calculator();

        String s = "1,2";
        assertEquals(3, calc.evaluateString(s));
    }

    @Test
    public void testStringWithUnknownAmountOfNumbers() throws Exception {
        Calculator calc = new Calculator();

        String s = "1,2,3,4";
        assertEquals(10, calc.evaluateString(s));
    }

    @Test
    public void testStringWithNumbersSeperatedWithCommasAndNewLines() throws Exception {
        Calculator calc = new Calculator();

        String s = "1\n2,3";
        assertEquals(6, calc.evaluateString(s));
    }

    @Test
    public void testStringWithCertainDelimiter() throws Exception {
        Calculator calc = new Calculator();

        String s = "//;\n1;2";
        assertEquals(3, calc.evaluateString(s));
    }
}
