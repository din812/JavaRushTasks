package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTokens("level22.lesson13.task01", ".")));
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer sT = new StringTokenizer(query, delimiter);

        ArrayList<String> strings = new ArrayList<>();

        while (sT.hasMoreTokens()) {
            strings.add(sT.nextToken());
        }
        String[] result = strings.toArray(new String[0]);
        return result;
    }
}
