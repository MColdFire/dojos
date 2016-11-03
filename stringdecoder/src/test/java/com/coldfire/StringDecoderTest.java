package com.coldfire;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringDecoderTest {

    private StringDecoder stringDecoder = new StringDecoder();

    @Test
    public void decodeWithoutSquareBrackets() {
        assertEquals("abc", stringDecoder.decodeString("abc"));
    }

    @Test
    public void decodeWithOneSquareBrackets() {
        assertEquals("aaa", stringDecoder.decodeString("3[a]"));
    }

    @Test
    public void decodeWithTwoSequentialBrackets() {
        assertEquals("aaabcbc", stringDecoder.decodeString("3[a]2[bc]"));
    }

    @Test
    public void decodeWithComposedBrackets() {
        assertEquals("accaccacc", stringDecoder.decodeString("3[a2[c]]"));
    }

    @Test
    public void decodeWithAndWithoutBrackets() {
        assertEquals("abcabccdcdcdef", stringDecoder.decodeString("2[abc]3[cd]ef"));
    }
}
