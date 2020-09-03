package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedInputStream input = new BufferedInputStream(new FileInputStream(reader.readLine()));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(reader.readLine()));

        byte[] allContents = new byte[input.available()];
        int count = input.read(allContents, 0, allContents.length);
        input.close();;

        ArrayList<String> rawNumbers = new ArrayList<>(Arrays.asList(new String(allContents).split(" ")));
        StringBuilder result = new StringBuilder();
        for (String s : rawNumbers) {
            result.append((int) Math.round(Double.parseDouble(s))).append(" ");
        }

        byte[] wData = result.toString().getBytes();
        output.write(wData);
        output.close();
    }
}
