package com.coldfire;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDecoder {

    public static final String REGEX = "\\d+\\[{1}\\w+]{1}";

    public String decodeString(String s) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(s);
        String result = s;
        while (matcher.find()) {
            String group = matcher.group(0);
            result = result.replace(group, decodeOneBrackets(group));
            matcher = pattern.matcher(result);
        }
        return result;
    }

    private String decodeOneBrackets(String s) {
        String k = s.substring(0, s.indexOf("["));
        String encodedString = s.substring(s.indexOf("[") + 1, s.indexOf("]"));
        return buildDecodedString(k, encodedString);
    }

    private String buildDecodedString(String k, String encodedString) {
        String result = "";
        for(int i = 0; i < Integer.valueOf(k); i++) {
            result += encodedString;
        }
        return result;
    }
}
