package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        String line;
        StringBuilder finalString = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            String[] lines = line.split(" ");
            for (int i = 0; i < lines.length; i++) {
                if (lines[i].length() > 6) {
                    finalString.append(lines[i] + ",");
                }
            }
        }
        if (finalString.length() > 1) {
            finalString.replace(finalString.length()-1, finalString.length(), "");
        }
        writer.write(finalString.toString());
        reader.close();
        writer.close();

    }
}
