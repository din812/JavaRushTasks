package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        BufferedReader br1 = null;
        try {
            while (true) {
                br1 = new BufferedReader(new FileReader(line = br.readLine()));
                br1.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(line);
            try {
                br.close();
            } catch (IOException ioException) {

            }
        } catch (IOException e) {

        }
    }
}
