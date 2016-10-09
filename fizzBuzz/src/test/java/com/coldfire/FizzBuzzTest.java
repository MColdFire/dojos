package com.coldfire;

import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzTest {

    // First Test
    @Test
    public void printNumbersFrom_1_to_100 (){
        for (int i = 1; i<= 100; i++) {
            if(FizzBuzz.isMultipleOf_3_and_5(i)) {
                Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(i));
            } else if(FizzBuzz.isMultipleOf_3(i)) {
                Assert.assertEquals("Fizz", FizzBuzz.fizzBuzz(i));
            } else if(FizzBuzz.isMultipleOf_5(i)) {
                Assert.assertEquals("Buzz", FizzBuzz.fizzBuzz(i));
            } else {
                Assert.assertEquals(Integer.toString(i), FizzBuzz.fizzBuzz(i));
            }
        }
    }

    // TDD Baby steps

    @Test
    public void printFizzFor_3 () {
        Assert.assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
    }

    @Test
    public void printFizzFor_6 () {
        Assert.assertEquals("Fizz", FizzBuzz.fizzBuzz(6));
    }

    @Test
    public void printBuzzFor_5 () {
        Assert.assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
    }

    @Test
    public void printBuzzFor_10 () {
        Assert.assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
    }

    @Test
    public void printFizzBuzzFor_15 () {
        Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
    }

    @Test
    public void printFizzBuzzFor_30 () {
        Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30));
    }

}
