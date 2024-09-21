package com.platzi.javatests.util;

public class StringUtilTest {
public static void main(String[] args) {

    assertEquals(StringUtil.repeat("hola", 3), "holaholahola");
    assertEquals(StringUtil.repeat("hola", 1), "hola");

}

    private static void assertEquals(String actualValue, String expectedValue) {
        if (!actualValue.equals(expectedValue)) {
            throw new RuntimeException(actualValue + " is not equal to expected" + expectedValue);
        }
    }
}