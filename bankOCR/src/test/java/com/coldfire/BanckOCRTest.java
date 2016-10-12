package com.coldfire;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BanckOCRTest{

    // User Story 1
    @Test
    @Ignore("Used on first baby steps")
    public void scannerReadsNumber_1() {
        String[] entry = {
            "   ",
            "  |",
            "  |",
        };
        assertEquals(1, BankOCR.scan(entry));
    }

    @Test
    @Ignore("Used on first baby steps")
    public void scannerReadsNumber_2() {
        String[] entry = {
                " _ ",
                " _|",
                "|_ ",
        };
        assertEquals(2, BankOCR.scan(entry));
    }

    @Test
    @Ignore("Used on first baby steps")
    public void scannerReadsNumbersFrom_1_to_9() {
        for(int i = 0; i < 10; i++) {
            assertEquals(i, BankOCR.scan(BankOCR.NUMBERS[i]));
        }
    }

    @Test
    public void scannerReadsAFullEntry() {
        String[] fullEntry1 = {
                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                "  ||_  _|  | _||_|  ||_| _|",
                "                           "
        };

        assertEquals(123456789, BankOCR.scan(fullEntry1));
    }

}
