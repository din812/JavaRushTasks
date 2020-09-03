package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        int i;
        int count = 0;

        while ((i = fileInputStream.read()) != -1) {
            if (i >= 'A' && i <= 'Z' || i >= 'a' && i <= 'z') {
                count++;
            }
        }

        System.out.println(count);
        fileInputStream.close();
    }
}
