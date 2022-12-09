package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @Test
    public void testEmptyString() throws Exception {
        String s = "";
        assertEquals(0, calc.evaluateString(s));
    }

    @Test
    public void testStringWithOneNumber() throws Exception {
        String s = "1";
        assertEquals(1, calc.evaluateString(s));
    }

    @Test
    public void testStringWithTwoNumbers() throws Exception {
        String s = "1,2";
        assertEquals(3, calc.evaluateString(s));
    }

    @Test
    public void testStringWithUnknownAmountOfNumbers() throws Exception {
        String s = "1,2,3,4";
        assertEquals(10, calc.evaluateString(s));
    }

    @Test
    public void testStringWithNumbersSeperatedWithCommasAndNewLines() throws Exception {
        String s = "1\n2,3";
        assertEquals(6, calc.evaluateString(s));
    }

    @Test
    public void testStringWithCertainDelimiter() throws Exception {
        String s = "//;\n1;2";
        assertEquals(3, calc.evaluateString(s));
    }

    @Test
    public void testStringWithNumbersGreaterThanThousand() throws Exception {
        String s = "//;\n10000000;200;3;3543";
        assertEquals(203, calc.evaluateString(s));
    }

    @Test
    public void testStringWithDelimitersOfAnyLength() throws Exception {
        String s = "//[***]\n1***2***3";
        assertEquals(6, calc.evaluateString(s));
    }

    @Test
    public void testStringWithMultipleDelimiters() throws Exception {
        String s = "//[*][%]\n1*2%3";
        assertEquals(6, calc.evaluateString(s));
    }
}
