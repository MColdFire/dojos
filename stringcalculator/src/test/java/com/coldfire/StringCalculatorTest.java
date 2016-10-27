package com.coldfire;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void calculatorReturns_0_forEmptyString() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void calculatorReturns_sum_forOneNumber() {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void calculatorReturns_sum_forTwoNumbers() {
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void calculatorReturns_sum_forThreeNumbers() {
        assertEquals(8, stringCalculator.add("1,2,5"));
    }

    @Test
    public void calculatorCanHandleNewLines() {
        assertEquals(6, stringCalculator.add("1\n5"));
    }

    @Test
    public void calculatorCanHandleNewLinesAndCommas() {
        assertEquals(13, stringCalculator.add("1\n5,7"));
    }

    @Test
    public void calculatorCanHandleSpecificDelimiter() {
        assertEquals(12, stringCalculator.add("//;\n5;7"));
    }

    @Test
    public void calculatorRejectsNegativeNumber(){
        try {
            stringCalculator.add("-1,2");
            fail("Exception should have been thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives not allowed: -1", e.getMessage());
        }
    }

    @Test
    public void calculatorRejectsNegativeNumbers(){
        try {
            stringCalculator.add("-1,2,-3");
            fail("Exception should have been thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives not allowed: -1,-3", e.getMessage());
        }
    }

    @Test
    public void calculatorIgnoresNumbersGreaterThan_1000() {
        assertEquals(1006, stringCalculator.add("1,1000,5"));
        assertEquals(6, stringCalculator.add("1,1001,5"));
    }

    @Test
    public void calculatorCanHandleDelimitersOfAnyLength() {
        assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void calculatorCanHandleMultipleDelimiters() {
        assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void calculatorCanHandleMultipleDelimitersWithDifferentLengths() {
        assertEquals(6, stringCalculator.add("//[***][%]\n1***2%3"));
    }

}
