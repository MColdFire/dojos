package com.coldfire;

import com.google.common.collect.Lists;

import java.util.List;

public class PrimeFactors {

    public static List<Integer> generate(int number) {
        List<Integer> primeFactors = Lists.newArrayList();
        while (number % 2 == 0) {
            number /= 2;
            primeFactors.add(2);
        }
        if(number >= 3) {
            int i = 3;
            while(i <= number) {
                if(number % i == 0) {
                    primeFactors.add(i);
                    number /= i;
                } else {
                    i++;
                }
            }
        }
        return primeFactors;
    }

}
