package com.coldfire;

import java.util.ArrayList;
import java.util.List;

public class BankOCR
{
    public static final String[][] NUMBERS = {
            {
                    " _ ",
                    "| |",
                    "|_|",
            },
            {
                    "   ",
                    "  |",
                    "  |",
            },
            {
                    " _ ",
                    " _|",
                    "|_ ",
            },
            {
                    " _ ",
                    " _|",
                    " _|",
            },
            {
                    "   ",
                    "|_|",
                    "  |",
            },
            {
                    " _ ",
                    "|_ ",
                    " _|",
            },
            {
                    " _ ",
                    "|_ ",
                    "|_|",
            },
            {
                    " _ ",
                    "  |",
                    "  |",
            },
            {
                    " _ ",
                    "|_|",
                    "|_|",
            },
            {
                    " _ ",
                    "|_|",
                    " _|",
            }
    };
    public static final int LINE_LENGTH = 27;
    public static final int NUMBER_LINE_SIZE = 3;


    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static int scan(String[] fullEntry) {
        List<String[]> entries = splitFullEntry(fullEntry);
        List<Integer> numbers = eveluateAllEntries(entries);
        return  concatNumbers(numbers);
    }

    private static int concatNumbers(List<Integer> numbers) {
        int value = 0;
        do {
            Integer integer = numbers.remove(0);
            value = (value * 10) + integer;
        } while(!numbers.isEmpty());
        return value;
    }

    private static List<Integer> eveluateAllEntries(List<String[]> entries) {
        List<Integer> numbers = new ArrayList<Integer>();
        for(String[] entry: entries) {
            numbers.add(evaluateNumber(entry));
        }
        return numbers;
    }

    private static List<String[]> splitFullEntry(String[] fullEntry) {
        List<String[]> entries = new ArrayList<String[]>();
        for(int i = 0; i <= LINE_LENGTH - NUMBER_LINE_SIZE; i+= NUMBER_LINE_SIZE) {
            String line0 = fullEntry[0].substring(i, i + NUMBER_LINE_SIZE);
            String line1 = fullEntry[1].substring(i, i + NUMBER_LINE_SIZE);
            String line2 = fullEntry[2].substring(i, i + NUMBER_LINE_SIZE);
            String[] entry = {line0, line1, line2};
            entries.add(entry);
        }
        return entries;
    }


    private static int evaluateNumber(String[] entry) {
        for (int i = 0; i < 10; i++) {
            if(isNumber(i, entry)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Could not evaluate number");
    }

    private static boolean isNumber(int expected, String[] entry) {
        for(int i = 0; i < 3; i++) {
            if(!(entry[i]).equals(NUMBERS[expected][i])) {
                return false;
            }
        }
        return true;
    }

}
