package com.coldfire;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public int add(String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }
        String separatorRegex = constructSeparatorRegex(numbers);
        numbers = numbers.substring(numbers.indexOf("\n", 2) + 1);
        String[] seperate_numbers = numbers.split(separatorRegex);
        List<Integer> int_values = Arrays.stream(seperate_numbers)
                .map(s -> Integer.valueOf(s))
                .collect(Collectors.toList());
        checkNoNegativeNumber(int_values);
        return int_values.stream()
                .filter(n -> n <= 1000)
                .reduce(0, (a, b) -> a + b);
    }

    private void checkNoNegativeNumber(List<Integer> seperate_numbers) {
        List<Integer> negativeIntegers =  seperate_numbers.stream()
                    .filter(n -> n < 0)
                    .collect(Collectors.toList());

        if(negativeIntegers.size() > 0) {
            throw new IllegalArgumentException("Negatives not allowed: " +
                    negativeIntegers.stream()
                            .map(s -> Integer.toString(s))
                            .reduce((a,b) -> a + "," + b)
                            .get());
        }
    }

    private String constructSeparatorRegex(String numbers) {
        String separatorRegex = ",|\n";
        if(withSpecificDelimiter(numbers)) {
            separatorRegex = numbers.substring(2, numbers.indexOf("\n", 2));
            if (withLengthyDelimiter(separatorRegex)) {
                String[] distinctSeparators = separatorRegex.substring(1, separatorRegex.length() - 1).split("]\\[");
                separatorRegex = constructRegexFromSeparators(distinctSeparators);
            }
        }
        return separatorRegex;
    }

    private String constructRegexFromSeparators(String[] distinctSeparators) {
        String regexpr = Arrays.stream(distinctSeparators).reduce((s1, s2) -> s1 + "|" + s2).get();
        return regexpr.replaceAll("\\*", "\\\\*");
    }

    private boolean withLengthyDelimiter(String separatorRegex) {
        return separatorRegex.startsWith("[") && separatorRegex.endsWith("]");
    }

    private boolean withSpecificDelimiter(String numbers) {
        return numbers.startsWith("//");
    }
}
