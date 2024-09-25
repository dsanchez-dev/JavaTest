package com.platzi.javatests.romanumbers;

public class RomanNumerals {

    public static String arabicToRoman(int n) {
        StringBuilder roman = new StringBuilder();

        int arabicsValues[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String romans[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < arabicsValues.length; i++) {
            while (n >= arabicsValues[i]) {
                roman.append(romans[i]);
                n -= arabicsValues[i];
            }
        }
        return roman.toString();
    }
}
