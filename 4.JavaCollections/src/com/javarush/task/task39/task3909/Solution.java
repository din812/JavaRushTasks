package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        //System.out.println(isOneEditAway("spot", "ghost"));
    }

    public static boolean isOneEditAway(String first, String second) {
        if (first.equals(second)) {
            return true;
        }
        if (first == null | second == null) {
            return false;
        }
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        char[] chars1 = first.toCharArray();
        char[] chars2 = second.toCharArray();

        boolean wasBadChar = false;

        for (int i = 0, j = 0; i < Math.min(chars1.length, chars2.length); i++, j++) {
            if (chars1[i] != chars2[j]) {
                if (wasBadChar) {
                    return false;
                }
                if (chars1.length > chars2.length) {
                    j--;
                } else if (chars1.length < chars2.length) {
                    i--;
                }
                wasBadChar = true;
            }
        }
        return true;
    }
}
