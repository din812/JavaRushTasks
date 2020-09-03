package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileReader fr = new FileReader(file1);
        FileWriter fw = new FileWriter(file2);

        int x = 1;

        while (fr.ready()) {
            if (x == 0) {
                fw.append((char) fr.read());
                x = 1;
            } else {
                x = fr.read();
                x = 0;
            }
        }
        reader.close();
        fr.close();
        fw.close();
    }
}
