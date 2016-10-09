package com.coldfire;

public class FizzBuzz
{
    public static void main( String[] args ) {
        for(int i = 1; i <= 100; i++) {
            System.out.println(fizzBuzz(i));
        }
    }

    public static String fizzBuzz(int i) {
        if(isMultipleOf_3_and_5(i)) {
            return "FizzBuzz";
        }
        if(isMultipleOf_3(i)) {
            return "Fizz";
        }
        if(isMultipleOf_5(i)) {
            return "Buzz";
        }
        return Integer.toString(i);
    }

    static boolean isMultipleOf_3_and_5(int i) {
        return isMultipleOf_3(i) && isMultipleOf_5(i);
    }

    static boolean isMultipleOf_5(int i) {
        return i % 5 == 0;
    }

    static boolean isMultipleOf_3(int i) {
        return i % 3 == 0;
    }
}
