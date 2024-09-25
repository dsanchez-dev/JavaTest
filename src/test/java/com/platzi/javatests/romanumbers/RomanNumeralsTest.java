package com.platzi.javatests.romanumbers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class RomanNumeralsTest {

    private final int input;
    private final String expected;

    public RomanNumeralsTest(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{//{1, "I"}, // 1
                {1, "I"}, // 1
                {2, "II"}, // 2
                {3, "III"}, // 3
                {5, "V"}, // 4
                {6, "VI"}, // 5
                {7, "VII"}, // 6
                {10, "X"}, // 7
                {11, "XI"}, // 8
                {15, "XV"}, // 9
                {16, "XVI"}, // 10
                {50, "L"}, // 11
                {51, "LI"}, // 12
                {55, "LV"}, // 13
                {56, "LVI"}, // 14
                {60, "LX"}, // 15
                {70, "LXX"}, // 16
                {80, "LXXX"}, // 17
                {81, "LXXXI"}, // 18
                {85, "LXXXV"}, // 19
                {86, "LXXXVI"}, // 20
                {126, "CXXVI"}, // 21
                {2507, "MMDVII"} // 22
        });
    }

    @Test
    public void  testArabicToRoman(){
        assertEquals(expected, RomanNumerals.arabicToRoman(input));
    }
}