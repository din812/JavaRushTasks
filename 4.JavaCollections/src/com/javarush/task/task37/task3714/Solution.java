package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.junit.Assert;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));

        Assert.assertEquals(romanToInteger("IV"), 4);
        Assert.assertEquals(romanToInteger("VI"), 6);
        Assert.assertEquals(romanToInteger("VIII"), 8);
        Assert.assertEquals(romanToInteger("IX"), 9);
        Assert.assertEquals(romanToInteger("XV"), 15);
        Assert.assertEquals(romanToInteger("XIX"), 19);
        Assert.assertEquals(romanToInteger("XL"), 40);
        Assert.assertEquals(romanToInteger("XLII"), 42);
        Assert.assertEquals(romanToInteger("LX"), 60);
        Assert.assertEquals(romanToInteger("LXXX"), 80);
        Assert.assertEquals(romanToInteger("LXXXIII"), 83);
        Assert.assertEquals(romanToInteger("XCIV"), 94);
        Assert.assertEquals(romanToInteger("XC"), 90);
        Assert.assertEquals(romanToInteger("CL"), 150);
        Assert.assertEquals(romanToInteger("CCLXXXIII"), 283);
        Assert.assertEquals(romanToInteger("DCCC"), 800);
        Assert.assertEquals(romanToInteger("MCMLXXXVIII"), 1988);
        Assert.assertEquals(romanToInteger("MMDCLXXXIII"), 2683);
        Assert.assertEquals(romanToInteger("MMDDCCLLXXVVII"), 3332);
        Assert.assertEquals(romanToInteger("MMMD"), 3500);
    }

    public static int romanToInteger(String s) {
        HashMap<String, Integer> romanNumbers = new HashMap<>();
        romanNumbers.put("I", 1);
        romanNumbers.put("V", 5);
        romanNumbers.put("X", 10);
        romanNumbers.put("L", 50);
        romanNumbers.put("C", 100);
        romanNumbers.put("D", 500);
        romanNumbers.put("M", 1000);

        String[] chars = s.toUpperCase().split("(?!^)");

        int[] nums = new int[chars.length];

        int res = 0;

        for (int i = 0; i < chars.length; i++) {
            int s1 = romanNumbers.get(chars[i]);

            if (i + 1 < chars.length) {
                int s2 = romanNumbers.get(chars[i + 1]);

                if (s1 >= s2) {
                    res = res + s1;
                }
                else {
                    res = res + s2 - s1;
                    i++;
                }
            }
            else {
                res = res + s1;
                i++;
            }
        }

        return res;
    }
}
