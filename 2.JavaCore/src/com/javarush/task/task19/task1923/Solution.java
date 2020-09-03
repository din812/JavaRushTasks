package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter reader2 = new BufferedWriter(new FileWriter(args[1]));

        String line;

        while ((line = reader1.readLine()) != null) {
            String[] words = line.toLowerCase().split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].matches("(\\S*\\d\\S*)")) {
                    reader2.write(words[i] + " ");
                }
            }
        }
        reader2.close();
        reader1.close();
    }
}
