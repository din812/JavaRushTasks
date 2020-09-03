package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br1 = new BufferedReader(new FileReader(br.readLine()));

        String line = br1.readLine();
        while (line != null) {
            if (Integer.parseInt(args[0]) == Integer.parseInt(line.replaceAll(" .+$", ""))) {
                System.out.println(line);
                break;
            }
            line = br1.readLine();
        }





        br.close();
        br1.close();
    }

}
